package com.psg.ramasubramanin.linkedin.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

@Configuration
public class CassandraConfiguration {

    @Value("${cassandra.cluster.ip}")
    private String contactPoint;

    @Value("${cassandra.cluster.port}")
    private Integer port;

    @Value("${cassandra.cluster.keyspace}")
    private String keyspace;

    @Bean
    public CassandraClusterFactoryBean cassandraClusterFactory() {
        CassandraClusterFactoryBean cassandraClusterFactory = new CassandraClusterFactoryBean();
        cassandraClusterFactory.setContactPoints(contactPoint);
        cassandraClusterFactory.setPort(port);
        return cassandraClusterFactory;
    }

    @Bean
    public CassandraMappingContext cassandraMappingContext() {
        return new BasicCassandraMappingContext();
    }

    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(cassandraMappingContext());
    }

    @Bean
    public CassandraSessionFactoryBean session() {
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setKeyspaceName(this.keyspace);
        try {
            session.setCluster(cassandraClusterFactory().getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setConverter(converter());
        session.setSchemaAction(SchemaAction.NONE);
        return session;
    }

    @Bean
    public CassandraOperations cassandraTemplate() {
        return new CassandraTemplate(session().getObject());
    }
}

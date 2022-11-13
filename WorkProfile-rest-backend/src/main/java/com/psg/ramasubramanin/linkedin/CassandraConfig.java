package com.psg.ramasubramanin.linkedin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Getter
@Setter
@Configuration
@EnableCassandraRepositories("com.psg.ramasubramanin.linkedin")
public class CassandraConfig extends AbstractCassandraConfiguration {
    @Value("${spring.data.cassandra.contact-points}")
    private String cassandraIP;
    @Value("${spring.data.cassandra.port}")
    private int port;
    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspace;
    @Value("${spring.data.cassandra.base-packages}")
    private String basePackages;

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }

    @Override
    protected boolean getMetricsEnabled() {
        return false;
    }
}

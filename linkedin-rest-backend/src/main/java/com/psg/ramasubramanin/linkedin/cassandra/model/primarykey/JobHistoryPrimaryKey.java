package com.psg.ramasubramanin.linkedin.cassandra.model.primarykey;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@Getter
@Setter
@PrimaryKeyClass
public class JobHistoryPrimaryKey {
    @PrimaryKeyColumn(value="id", type = PrimaryKeyType.PARTITIONED)
    private Integer id;

    @PrimaryKeyColumn(value="email", ordinal = 0)
    private String email;
}

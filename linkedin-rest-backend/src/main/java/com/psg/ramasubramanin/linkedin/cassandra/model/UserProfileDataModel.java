package com.psg.ramasubramanin.linkedin.cassandra.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table(value = "user_profile")
public class UserProfileDataModel {

    @PrimaryKeyColumn(value = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID userId;
    @Column(value="firstname")
    private String firstname;
    @Column(value="lastname")
    private String lastname;
    @Column(value="email")
    private String email;
    @Column(value="about")
    private String about;
}

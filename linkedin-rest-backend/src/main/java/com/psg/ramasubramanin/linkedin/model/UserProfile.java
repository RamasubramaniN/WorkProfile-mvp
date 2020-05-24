package com.psg.ramasubramanin.linkedin.model;

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
@Table
public class UserProfile {

    @PrimaryKeyColumn(value = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID userId;
    @Column(value="firstname")
    private String firstname;
    @Column(value="lastname")
    private String lastname;
    @Column(value="email")
    private String email;
    @Column(value="dob")
    private Date birthDate;
    @Column(value="about")
    private String about;
    @Column(value="publication")
    private List<Publication> publicationList;
    @Column(value="education")
    private List<EducationHistory> educationHistoryList;
    @Column(value="job_history")
    private List<JobHistory> jobHistoryList;
    @Column(value="languages_known")
    private List<String> languageKnownList;
}

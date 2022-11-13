package com.psg.ramasubramanin.linkedin.cassandra.model;

import com.psg.ramasubramanin.linkedin.cassandra.model.primarykey.JobHistoryPrimaryKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@Table(value = "job_history")
public class JobHistoryDataModel {

    @PrimaryKey
    private JobHistoryPrimaryKey jobHistoryPrimaryKey;

    @Column(value = "from_year")
    private Integer fromYear;

    @Column(value = "to_year")
    private Integer toYear;

    @Column(value = "designation")
    private String designation;

    @Column(value="employer_name")
    private String employerName;

    @Column(value="location")
    private String location;
}

package com.psg.ramasubramanin.linkedin.cassandra.model;

import com.psg.ramasubramanin.linkedin.cassandra.model.primarykey.EducationPrimaryKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Getter
@Setter
@Table(value = "education")
public class EducationDataModel implements Serializable {

    @PrimaryKey
    private EducationPrimaryKey educationPrimaryKey;

    @Column(value="from_year")
    private Integer fromYear;

    @Column(value="to_year")
    private Integer toYear;

    @Column(value="obtained_grade")
    private Double obtainedGrade;

    @Column(value="total_grade")
    private Double totalGrade;

    @Column(value="location")
    private String location;

    @Column(value="institution_name")
    private String institutionName;

    @Column(value="degree_name")
    private String degreeName;
}

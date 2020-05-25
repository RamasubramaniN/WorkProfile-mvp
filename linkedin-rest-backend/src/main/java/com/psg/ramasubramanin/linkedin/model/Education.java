package com.psg.ramasubramanin.linkedin.model;

import lombok.Getter;
import java.io.Serializable;

@Getter
public class Education implements Serializable {

    private Integer fromYear;
    private Integer toYear;
    private Double obtainedGrade;
    private Double totalGrade;
    private String location;
    private String institutionName;
    private String degreeName;

    public Education(Integer fromYear, Integer toYear, String degreeName,
                     String institutionName, String location, Double totalGrade,
                     Double obtainedGrade) {
        this.fromYear = fromYear;
        this.totalGrade = totalGrade;
        this.toYear = toYear;
        this.obtainedGrade = obtainedGrade;
        this.institutionName = institutionName;
        this.location = location;
        this.degreeName = degreeName;
    }
}

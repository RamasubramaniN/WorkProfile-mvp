package com.psg.ramasubramanin.linkedin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationHistory {
    private Integer fromYear;
    private Integer toYear;
    private Double obtainedGrade;
    private Double totalGrade;
    private String location;
    private String institutionName;
    private String degreeName;
}

package com.psg.ramasubramanin.linkedin.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class JobHistory implements Serializable {

    private Integer fromYear;
    private Integer toYear;
    private String designation;
    private String employerName;
    private String location;

    public JobHistory(String designation, String employerName, String location,
                      Integer fromYear, Integer toYear) {
        this.designation = designation;
        this.employerName = employerName;
        this.location = location;
        this.fromYear = fromYear;
        this.toYear = toYear;
    }
}

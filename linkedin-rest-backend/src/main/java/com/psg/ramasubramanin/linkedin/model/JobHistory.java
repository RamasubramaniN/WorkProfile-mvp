package com.psg.ramasubramanin.linkedin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobHistory {
    private Integer fromYear;
    private Integer toYear;
    private String designation;
    private String companyName;
    private String location;
}

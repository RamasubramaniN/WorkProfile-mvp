package com.psg.ramasubramanin.linkedin.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserProfile {

    private UUID userId;
    private String firstname;
    private String lastname;
    private String email;
    private Date birthDate;
    private String about;

    private List<Publication> publicationList;
    private List<EducationHistory> educationHistoryList;
    private List<JobHistory> jobHistoryList;
    private List<String> languageKnownList;
}

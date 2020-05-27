package com.psg.ramasubramanin.linkedin.model;

import lombok.Getter;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
public class UserProfile implements Serializable {
    private UUID userId;
    private String firstname;
    private String lastname;
    private String email;
    private String about;
    private List<JobHistory> jobHistory;
    private List<Education> educationHistory;
    private List<Publication> publicationHistory;

    public UserProfile(UUID userId, String firstname, String lastname,
                       String about, String email, List<JobHistory> jobHistory,
                       List<Education> educationHistory, List<Publication> publicationHistory) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.about = about;
        this.email = email;
        this.jobHistory = jobHistory;
        this.educationHistory = educationHistory;
        this.publicationHistory = publicationHistory;
    }
}

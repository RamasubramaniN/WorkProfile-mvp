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
    private List<JobHistory> jobHistoryList;
    private List<Education> educationHistoryList;
    private List<Publication> publicationList;

    public UserProfile(UUID userId, String firstname, String lastname,
                       String about, String email, List<JobHistory> jobHistoryList,
                       List<Education> educationHistoryList, List<Publication> publicationList) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.about = about;
        this.email = email;
        this.jobHistoryList = jobHistoryList;
        this.educationHistoryList = educationHistoryList;
        this.publicationList = publicationList;
    }
}

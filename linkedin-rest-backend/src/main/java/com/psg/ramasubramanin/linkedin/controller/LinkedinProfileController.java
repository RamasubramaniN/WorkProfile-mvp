package com.psg.ramasubramanin.linkedin.controller;

import com.psg.ramasubramanin.linkedin.cassandra.model.UserProfileDataModel;
import com.psg.ramasubramanin.linkedin.model.UserProfile;
import com.psg.ramasubramanin.linkedin.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping(path="/users")
@RestController
public class LinkedinProfileController {

    private UserProfileService userProfileService;

    @Autowired
    public LinkedinProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping(path = "/{userId}", produces = "application/json")
    private UserProfile getUserProfile(@PathVariable String userId) {
        return userProfileService.findById(UUID.fromString(userId));
    }
//https://stackoverflow.com/questions/51829850/how-to-mix-manual-sql-row-mapping-with-crudrepository-spring-data
}

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

    //http://localhost:8080/linkedin/users/9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6
    @GetMapping(path = "/{userId}", produces = "application/json")
    private UserProfile getUserProfile(@PathVariable String userId) {
        return userProfileService.findById(UUID.fromString(userId));
    }
}

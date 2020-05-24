package com.psg.ramasubramanin.linkedin.service.impl;

import com.psg.ramasubramanin.linkedin.dao.UserProfileDAO;
import com.psg.ramasubramanin.linkedin.model.UserProfile;
import com.psg.ramasubramanin.linkedin.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private UserProfileDAO userProfileDAO;

    @Autowired
    public UserProfileServiceImpl(UserProfileDAO userProfileDAO) {
        this.userProfileDAO = userProfileDAO;
    }

    @Override
    public UserProfile findById(UUID id) {
        return userProfileDAO.findById(id);
    }
}

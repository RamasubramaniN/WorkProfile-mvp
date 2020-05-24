package com.psg.ramasubramanin.linkedin.service;

import com.psg.ramasubramanin.linkedin.model.UserProfile;

public interface UserProfileService {
    /**
     * Get {@link UserProfile} by id.
     * @param id
     * @return UserProfile
     */
    UserProfile findById(Integer id);
}

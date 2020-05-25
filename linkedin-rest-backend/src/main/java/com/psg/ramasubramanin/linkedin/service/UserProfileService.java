package com.psg.ramasubramanin.linkedin.service;

import com.psg.ramasubramanin.linkedin.model.UserProfile;

import java.util.UUID;

public interface UserProfileService {
    /**
     * Get {@link UserProfile} by id.
     * @param id
     * @return @{@link UserProfile}
     */
    UserProfile findById(UUID id);

}

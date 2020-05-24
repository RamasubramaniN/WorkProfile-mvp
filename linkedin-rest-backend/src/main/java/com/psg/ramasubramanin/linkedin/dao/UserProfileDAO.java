package com.psg.ramasubramanin.linkedin.dao;

import com.psg.ramasubramanin.linkedin.model.UserProfile;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserProfileDAO {

    /**
     * Get {@link UserProfile} by id.
     * @param id
     * @return UserProfile
     */
    UserProfile findById(Integer id);
}

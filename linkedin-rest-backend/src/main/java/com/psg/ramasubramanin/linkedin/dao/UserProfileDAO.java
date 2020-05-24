package com.psg.ramasubramanin.linkedin.dao;

import com.psg.ramasubramanin.linkedin.model.UserProfile;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserProfileDAO extends CassandraRepository<UserProfile, UUID> {
    @Query("SELECT * FROM user_profile WHERE id = :id")
    Optional<UserProfile> findById(@Param("id") UUID id);
}

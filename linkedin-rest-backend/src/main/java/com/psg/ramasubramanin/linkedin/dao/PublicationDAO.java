package com.psg.ramasubramanin.linkedin.dao;

import com.psg.ramasubramanin.linkedin.cassandra.model.PublicationDataModel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationDAO extends CassandraRepository<PublicationDataModel, String> {
    @Query("SELECT * FROM publication WHERE email = :email")
    List<PublicationDataModel> getPublicationList(@Param("email")String email);
}

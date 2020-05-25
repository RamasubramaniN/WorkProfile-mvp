package com.psg.ramasubramanin.linkedin.dao;

import com.psg.ramasubramanin.linkedin.cassandra.model.EducationDataModel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationDAO extends CassandraRepository<EducationDataModel, String> {
    @Query("SELECT * FROM education WHERE email = :email")
    List<EducationDataModel> getEducationHistoryList(@Param("email")String email);
}

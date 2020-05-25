package com.psg.ramasubramanin.linkedin.dao;

import com.psg.ramasubramanin.linkedin.cassandra.model.JobHistoryDataModel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobHistoryDAO extends CassandraRepository<JobHistoryDataModel, String> {
    @Query("SELECT * FROM job_history WHERE email = :email")
    List<JobHistoryDataModel> getJobHistoryList(@Param("email")String email);
}

package com.psg.ramasubramanin.linkedin.service;

import com.psg.ramasubramanin.linkedin.model.JobHistory;

import java.util.List;

public interface JobHistoryService {
    /**
     * Get Job History List.
     * @param email
     * @return @{@link java.util.ArrayList}{@link JobHistory}
     */
    List<JobHistory> getJobHistoryList(String email);
}

package com.psg.ramasubramanin.linkedin.service.impl;

import com.psg.ramasubramanin.linkedin.cassandra.model.JobHistoryDataModel;
import com.psg.ramasubramanin.linkedin.dao.JobHistoryDAO;
import com.psg.ramasubramanin.linkedin.model.JobHistory;
import com.psg.ramasubramanin.linkedin.service.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {

    private JobHistoryDAO jobHistoryDAO;

    @Autowired
    public JobHistoryServiceImpl(JobHistoryDAO jobHistoryDAO) {
        this.jobHistoryDAO = jobHistoryDAO;
    }

    @Override
    public List<JobHistory> getJobHistoryList(List<String> emailList) {
        List<JobHistory> jobHistoryList = new ArrayList<>();
        List<JobHistoryDataModel> jobHistoryDataModelList = new ArrayList<>();
        jobHistoryDataModelList.forEach(model -> {
            JobHistory jobHistory = new JobHistory(model.getDesignation(), model.getEmployerName(),
                    model.getLocation(), model.getFromYear(), model.getToYear());
            jobHistoryList.add(jobHistory);

        });
        return jobHistoryList;
    }
}

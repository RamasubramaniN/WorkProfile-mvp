package com.psg.ramasubramanin.linkedin.service.impl;

import com.psg.ramasubramanin.linkedin.dao.UserProfileDAO;
import com.psg.ramasubramanin.linkedin.cassandra.model.UserProfileDataModel;
import com.psg.ramasubramanin.linkedin.model.Education;
import com.psg.ramasubramanin.linkedin.model.JobHistory;
import com.psg.ramasubramanin.linkedin.model.Publication;
import com.psg.ramasubramanin.linkedin.model.UserProfile;
import com.psg.ramasubramanin.linkedin.service.EducationService;
import com.psg.ramasubramanin.linkedin.service.JobHistoryService;
import com.psg.ramasubramanin.linkedin.service.PublicationService;
import com.psg.ramasubramanin.linkedin.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private UserProfileDAO userProfileDAO;
    private PublicationService publicationService;
    private JobHistoryService jobHistoryService;
    private EducationService educationService;

    @Autowired
    public UserProfileServiceImpl(UserProfileDAO userProfileDAO,
                                  PublicationService publicationService,
                                  EducationService educationService,
                                  JobHistoryService jobHistoryService) {
        this.userProfileDAO = userProfileDAO;
        this.publicationService = publicationService;
        this.educationService = educationService;
        this.jobHistoryService = jobHistoryService;
    }

    @Override
    public UserProfile findById(UUID id) {
        UserProfileDataModel dataModel =  userProfileDAO.findById(id).get();
        List<Publication> publicationList = publicationService.getPublicationList(dataModel.getEmail());
        List<Education> educationList = educationService.getEducationList(dataModel.getEmail());
        List<JobHistory> jobHistoryList = jobHistoryService.getJobHistoryList(dataModel.getEmail());

        UserProfile userProfile = new UserProfile(dataModel.getUserId(), dataModel.getFirstname(),
                dataModel.getLastname(), dataModel.getAbout(), dataModel.getEmail()
        , jobHistoryList, educationList, publicationList);

        return userProfile;
    }
}

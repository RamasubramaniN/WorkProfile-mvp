package com.psg.ramasubramanin.linkedin.service.impl;

import com.psg.ramasubramanin.linkedin.cassandra.model.EducationDataModel;
import com.psg.ramasubramanin.linkedin.dao.EducationDAO;
import com.psg.ramasubramanin.linkedin.model.Education;
import com.psg.ramasubramanin.linkedin.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    private EducationDAO educationDAO;

    @Autowired
    public EducationServiceImpl(EducationDAO educationDAO) {
        this.educationDAO = educationDAO;
    }

    @Override
    public List<Education> getEducationList(List<String> emailList) {
        List<EducationDataModel> educationDataModelList = educationDAO.getEducationHistoryList(emailList);
        List<Education> educationList = new ArrayList<>();
        for(EducationDataModel model : educationDataModelList) {
            Education education = new Education(model.getFromYear(), model.getToYear(), model.getDegreeName()
                    , model.getInstitutionName(), model.getLocation(), model.getTotalGrade(),
                    model.getObtainedGrade());
            educationList.add(education);
        }
        return educationList;
    }
}

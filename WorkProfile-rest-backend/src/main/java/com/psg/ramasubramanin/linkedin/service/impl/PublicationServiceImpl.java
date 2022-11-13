package com.psg.ramasubramanin.linkedin.service.impl;

import com.psg.ramasubramanin.linkedin.cassandra.model.PublicationDataModel;
import com.psg.ramasubramanin.linkedin.dao.PublicationDAO;
import com.psg.ramasubramanin.linkedin.model.Publication;
import com.psg.ramasubramanin.linkedin.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationDAO publicationDAO;

    @Autowired
    public PublicationServiceImpl(PublicationDAO publicationDAO) {
        this.publicationDAO = publicationDAO;
    }

    @Override
    public List<Publication> getPublicationList(String email) {
        List<Publication> publicationList = new ArrayList<>();
        List<PublicationDataModel> publicationDataModelList = publicationDAO.getPublicationList(email);
        publicationDataModelList.forEach(model -> {
            Publication publication = new Publication(model.getTitle()
                                    ,model.getContent(), model.getYear());
            publicationList.add(publication);
        });
        return publicationList;
    }
}

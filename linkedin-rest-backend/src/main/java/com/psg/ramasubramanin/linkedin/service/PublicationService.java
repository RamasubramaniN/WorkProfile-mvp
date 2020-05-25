package com.psg.ramasubramanin.linkedin.service;

import com.psg.ramasubramanin.linkedin.model.Publication;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PublicationService {
    /**
     * Get Publication History
     * @param email
     * @return @{@link java.util.ArrayList}{@link Publication}
     */
    List<Publication> getPublicationList(String email);
}

package com.psg.ramasubramanin.linkedin.service;

import com.psg.ramasubramanin.linkedin.model.Education;

import java.util.List;

public interface EducationService {
    /**
     * Get Education History.
     * @param email
     * @return @{@link java.util.ArrayList}{@link Education}
     */
    List<Education> getEducationList(String email);
}

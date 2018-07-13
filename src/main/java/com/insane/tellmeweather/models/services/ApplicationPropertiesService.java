package com.insane.tellmeweather.models.services;

import com.insane.tellmeweather.models.entities.ApplicationPropertiesEntity;
import com.insane.tellmeweather.models.repositories.ApplicationPropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service (value = "app_service")
public class ApplicationPropertiesService {

    private final ApplicationPropertiesRepository applicationPropertiesRepository;

    @Autowired
    public ApplicationPropertiesService(ApplicationPropertiesRepository applicationPropertiesRepository) {
        this.applicationPropertiesRepository = applicationPropertiesRepository;
    }

    public Iterable<ApplicationPropertiesEntity> loadProperties() {
        return applicationPropertiesRepository.findAll();
    }
}
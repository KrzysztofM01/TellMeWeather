package com.insane.tellmeweather.models;

import com.insane.tellmeweather.models.services.ApplicationPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class ApplicationPropertiesBean {

    public final String API_KEY = "api_key";
    public final String WEBSITE_URL = "weatherPageURL";
    private final HashMap<String, String> content = new HashMap<>();
    @Autowired
    ApplicationPropertiesService applicationPropertiesService;

    public void loadProperties() {
        applicationPropertiesService.loadProperties().forEach(s -> content.put(s.getName(), s.getValue()));
    }

    public void setApplicationPropertiesService (ApplicationPropertiesService applicationPropertiesService) {
        this.applicationPropertiesService = applicationPropertiesService;
    }

    public HashMap<String, String> getContent() {
        return content;
    }
}

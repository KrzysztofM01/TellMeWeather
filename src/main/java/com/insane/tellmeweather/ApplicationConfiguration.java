package com.insane.tellmeweather;

import com.insane.tellmeweather.models.ApplicationPropertiesBean;
import com.insane.tellmeweather.models.services.ApplicationPropertiesService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan (value = "com.insane.tellmeweather")
public class ApplicationConfiguration {

    @Bean
    ApplicationPropertiesBean getApplicationPropertiesBean (ApplicationPropertiesService prop_service) {
        ApplicationPropertiesBean applicationPropertiesBean = new ApplicationPropertiesBean();
        applicationPropertiesBean.setApplicationPropertiesService(prop_service);
        applicationPropertiesBean.loadProperties();
        return applicationPropertiesBean;
    }

}

package com.insane.tellmeweather.models.repositories;

import com.insane.tellmeweather.models.entities.ApplicationPropertiesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationPropertiesRepository extends CrudRepository<ApplicationPropertiesEntity, Integer>{

}


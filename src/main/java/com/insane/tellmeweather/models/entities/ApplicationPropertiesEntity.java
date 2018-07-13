package com.insane.tellmeweather.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table (name="properties")
public class ApplicationPropertiesEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String value;
    private String comment;


}

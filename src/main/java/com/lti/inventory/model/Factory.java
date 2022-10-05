package com.lti.inventory.model;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@RestController
@CrossOrigin(origins = "*")
@Entity
public class Factory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int factoryId;
    private String factoryName;
    private String factoryLocation;

    public Factory(int factoryId, String factoryName, String factoryLocation) {
        this.factoryId = factoryId;
        this.factoryName = factoryName;
        this.factoryLocation = factoryLocation;
    }

    public Factory(){

    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryLocation() {
        return factoryLocation;
    }

    public void setFactoryLocation(String factoryLocation) {
        this.factoryLocation = factoryLocation;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "fId=" + factoryId +
                ", fName='" + factoryName + '\'' +
                ", fLocation='" + factoryLocation + '\'' +
                '}';
    }
}

package com.codegym.model.facility;

import com.codegym.model.facility.Facility;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FacilityType {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "facilityType")
    private Set<Facility> facilityList;
    private int deleteStatus;
    public FacilityType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(Set<Facility> facilityList) {
        this.facilityList = facilityList;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}

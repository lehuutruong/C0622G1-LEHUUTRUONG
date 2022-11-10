package com.codegym.dto;

import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class FacilityDto implements Validator {
    private int id;
    private String name;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;
    private int deleteStatus = 1;

    public FacilityDto() {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        switch (facilityDto.getFacilityType().getId()) {
            case 1:
                if (!facilityDto.getStandardRoom().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$") && !facilityDto.getStandardRoom().equals("")) {
                    errors.rejectValue("standardRoom", "standardRoomFacility.forbidden", "Standard Room malformed !");
                }
                if (!facilityDto.getDescriptionOtherConvenience().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$") && !facilityDto.getDescriptionOtherConvenience().equals("")) {
                    errors.rejectValue("descriptionOtherConvenience", "descriptionOtherConvenience.forbidden", "Description Other Convenience Room malformed !");
                }
                if (facilityDto.getPoolArea() < 0) {
                    errors.rejectValue("poolArea", "poolAreaFacility.forbidden", "Pool Area not blank");
                } else if (!(facilityDto.getPoolArea() > 0)) {
                    errors.rejectValue("poolArea", "poolArea.forbidden", "Pool Area malformed !");
                }

                if (facilityDto.getNumberOfFloors() > 0) {
                    errors.rejectValue("numberOfFloors", "numberOfFloorsFacility.forbidden", "Number Of Floors not blank");
                } else if (!(facilityDto.getNumberOfFloors() > 0)) {
                    errors.rejectValue("numberOfFloors", "numberOfFloorsFacility.forbidden", "Number Of Floors malformed !");
                }
                break;
            case 2:
                if (!facilityDto.getStandardRoom().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$") && !facilityDto.getStandardRoom().equals("")) {
                    errors.rejectValue("standardRoom", "standardRoomFacility.forbidden", "Standard Room malformed !");
                }

                if (!facilityDto.getDescriptionOtherConvenience().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$") && !facilityDto.getDescriptionOtherConvenience().equals("")) {
                    errors.rejectValue("descriptionOtherConvenience", "descriptionOtherConvenience.forbidden", "Description Other Convenience Room malformed !");
                }

                if (facilityDto.getNumberOfFloors() < 0) {
                    errors.rejectValue("numberOfFloors", "numberOfFloorsFacility.forbidden", "Number Of Floors not blank");
                } else if (!(facilityDto.getNumberOfFloors() > 0)) {
                    errors.rejectValue("numberOfFloors", "numberOfFloorsFacility.forbidden", "Number Of Floors malformed !");
                }
                break;
            case 3:
                if (facilityDto.facilityFree.equals("")) {
                    errors.rejectValue("facilityFree", "facilityFree.forbidden", "Facility Free cannot be left blank");
                }
                break;
        }

        if (!facilityDto.getName().matches("[a-zA-Z0-9]{5,50}") && !facilityDto.getName().equals("")) {
            errors.rejectValue("name", "nameFacility.forbidden", "Name malformed !");
        }

        if (facilityDto.getPoolArea() < 0) {
            errors.rejectValue("area", "areaFacility.forbidden", "Area not blank");
        } else if (facilityDto.getPoolArea() < 0) {
            errors.rejectValue("area", "areaFacility.forbidden", "Area malformed !");
        }

        if (facilityDto.getCost() < 0) {
            errors.rejectValue("cost", "costFacility.forbidden", "Cost not blank");
        } else if (!(facilityDto.getCost() > 0)) {
            errors.rejectValue("cost", "costFacility.forbidden", "Cost malformed !");
        }
        if (!(facilityDto.getMaxPeople() > 0)) {
            errors.rejectValue("maxPeople", "maxPeopleFacility.forbidden", "Max People malformed !");
        }

    }
}

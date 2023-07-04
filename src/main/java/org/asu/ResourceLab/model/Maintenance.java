package org.asu.ResourceLab.model;

import java.util.Date;

public class Maintenance {

    private int maintenanceID;
    private int resourceID;
    private int userID;
    private Date maintenanceDate;
    private String maintenanceDetails;

    // Default constructor
    public Maintenance() {
    }

    // Constructor with all parameters
    public Maintenance(int maintenanceID, int resourceID, int userID, Date maintenanceDate, String maintenanceDetails) {
        this.maintenanceID = maintenanceID;
        this.resourceID = resourceID;
        this.userID = userID;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceDetails = maintenanceDetails;
    }

    // Getters
    public int getMaintenanceID() {
        return maintenanceID;
    }

    public int getResourceID() {
        return resourceID;
    }

    public int getUserID() {
        return userID;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public String getMaintenanceDetails() {
        return maintenanceDetails;
    }

    // Setters
    public void setMaintenanceID(int maintenanceID) {
        this.maintenanceID = maintenanceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public void setMaintenanceDetails(String maintenanceDetails) {
        this.maintenanceDetails = maintenanceDetails;
    }
}

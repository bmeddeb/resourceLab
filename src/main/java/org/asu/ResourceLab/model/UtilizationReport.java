package org.asu.ResourceLab.model;

import java.util.Date;

public class UtilizationReport {

    private int reportID;
    private int resourceID;
    private int userID;
    private Date generatedDate;
    private String utilizationData;

    // Default constructor
    public UtilizationReport() {
    }

    // Constructor with all parameters
    public UtilizationReport(int reportID, int resourceID, int userID, Date generatedDate, String utilizationData) {
        this.reportID = reportID;
        this.resourceID = resourceID;
        this.userID = userID;
        this.generatedDate = generatedDate;
        this.utilizationData = utilizationData;
    }

    // Getters
    public int getReportID() {
        return reportID;
    }

    public int getResourceID() {
        return resourceID;
    }

    public int getUserID() {
        return userID;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public String getUtilizationData() {
        return utilizationData;
    }

    // Setters
    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public void setUtilizationData(String utilizationData) {
        this.utilizationData = utilizationData;
    }
}

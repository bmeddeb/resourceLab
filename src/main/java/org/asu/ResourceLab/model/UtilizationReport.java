package org.asu.ResourceLab.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class UtilizationReport {

    private Integer reportID;
    private Integer resourceID;
    private Integer userID;
    private Date generatedDate;
    private String utilizationData;
    private String reportType;


    // Default constructor
    public UtilizationReport() {

    }

    // Constructor with all parameters
    public UtilizationReport(Integer reportID, Integer resourceID, Integer userID, Date generatedDate, String utilizationData) {
        this.reportID = reportID;
        this.resourceID = resourceID;
        this.userID = userID; // Fixed here
        this.generatedDate = generatedDate;
        this.utilizationData = utilizationData;
    }
    public void setReportID(Integer reportID) {
        this.reportID = reportID;
    }
    public void setGeneratedDate(LocalDateTime generatedDate) {
        this.generatedDate = asDate(generatedDate);
    }

    public static java.util.Date asDate(LocalDateTime localDateTime) {
        return java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    // Getters
    public Integer getReportID() {
        return reportID;
    }

    public Integer getResourceID() {
        return resourceID;
    }

    public Integer getUserID() {
        return userID;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public String getUtilizationData() {
        return utilizationData;
    }

    // Setters
    public void setResourceID(Integer resourceID) {
        this.resourceID = resourceID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public void setUtilizationData(String utilizationData) {
        this.utilizationData = utilizationData;
    }

    public void setReportType (String resourceUtilization) {
        this.reportType = reportType;
    }

    public String getReportType () {
        return reportType;
    }
}


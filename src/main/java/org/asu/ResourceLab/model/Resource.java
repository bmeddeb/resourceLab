package org.asu.ResourceLab.model;

public class Resource {

    private int resourceID;
    private String resourceName;
    private String resourceDescription;
    private String resourceStatus;
    private String maintenanceStatus;

    // Default constructor
    public Resource() {
    }

    // Constructor with all parameters
    public Resource(int resourceID, String resourceName, String resourceDescription, String resourceStatus, String maintenanceStatus) {
        this.resourceID = resourceID;
        this.resourceName = resourceName;
        this.resourceDescription = resourceDescription;
        this.resourceStatus = resourceStatus;
        this.maintenanceStatus = maintenanceStatus;
    }

    // Getters
    public int getResourceID() {
        return resourceID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public String getResourceStatus() {
        return resourceStatus;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    // Setters
    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public void setResourceStatus(String resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }
}

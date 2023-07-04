package org.asu.ResourceLab.model;

import java.util.Date;

public class Booking {

    private int bookingID;
    private int userID;
    private int resourceID;
    private Date bookingDate;
    private Date bookingStartTime;
    private Date bookingEndTime;

    // Default constructor
    public Booking() {
    }

    // Constructor with all parameters
    public Booking(int bookingID, int userID, int resourceID, Date bookingDate, Date bookingStartTime, Date bookingEndTime) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.resourceID = resourceID;
        this.bookingDate = bookingDate;
        this.bookingStartTime = bookingStartTime;
        this.bookingEndTime = bookingEndTime;
    }

    // Getters
    public int getBookingID() {
        return bookingID;
    }

    public int getUserID() {
        return userID;
    }

    public int getResourceID() {
        return resourceID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Date getBookingStartTime() {
        return bookingStartTime;
    }

    public Date getBookingEndTime() {
        return bookingEndTime;
    }

    // Setters
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingStartTime(Date bookingStartTime) {
        this.bookingStartTime = bookingStartTime;
    }

    public void setBookingEndTime(Date bookingEndTime) {
        this.bookingEndTime = bookingEndTime;
    }
}

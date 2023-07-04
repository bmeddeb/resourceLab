package org.asu.ResourceLab.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.jdbc.core.JdbcTemplate;


public class User {

    private int userID;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userContact;
    private String role;

    // Constructor, getters, and setters omitted for brevity
    public User() {
    }

    public User(int userID, String userName, String userEmail, String userPassword, String userContact, String role) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userContact = userContact;
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName= userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role= role;
    }


    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", userName='" + userName + '\'' + ", userEmail='" + userEmail + '\'' + ", userPassword='" + userPassword + '\'' + ", userContact='" + userContact + '\'' + ", role='" + role + '\'' + '}';
    }





}

package com.spring.security.model;


import lombok.Data;

import java.io.Serializable;
import java.util.Objects;


public class CreateUserRequest implements Serializable {

    private String userName;
    private String userPassword;
    private String userEmail;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserRequest that)) return false;
        return Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getUserPassword(), that.getUserPassword()) && Objects.equals(getUserEmail(), that.getUserEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getUserPassword(), getUserEmail());
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}

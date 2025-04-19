package com.spring.security.model;

import java.io.Serializable;
import java.util.Objects;

public class LoginRequest implements Serializable {

    private String userName;
    private String userPassword;
    private String userRole;

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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginRequest that)) return false;
        return Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getUserPassword(), that.getUserPassword()) && Objects.equals(getUserRole(), that.getUserRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getUserPassword(), getUserRole());
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}

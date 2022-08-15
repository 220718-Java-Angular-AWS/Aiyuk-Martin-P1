package com.revatureERS.pojos;

import java.util.Objects;

public class EmployeeUser {

    private int userId;
    private String username;
    private String email;
    private String password;
    protected String department;
    private long AccountBalance;


    public EmployeeUser() {
    }

    public EmployeeUser(int userId, String username, String email, String password, String department, long accountBalance) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.department = department;
        this.AccountBalance = accountBalance;
    }

    public EmployeeUser(String username, String email, String password, String department) {
        //this.userId = null;
        this.username = username;
        this.email = email;
        this.password = password;
        this.department = department;
    }




    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        AccountBalance = accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeUser that = (EmployeeUser) o;
        return AccountBalance == that.AccountBalance && Objects.equals(userId, that.userId) && Objects.equals(username, that.username) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, password, department, AccountBalance);
    }

    @Override
    public String toString() {
        return "EmployeeUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", Role='" + department + '\'' +
                ", AccountBalance=" + AccountBalance +
                '}';
    }


}
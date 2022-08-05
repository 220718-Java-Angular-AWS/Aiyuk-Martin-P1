package com.revatureERS.daos;

import com.revatureERS.pojos.EmployeeUser;
import com.revatureERS.services.DataSourceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeUserDAO implements DatasourceCRUD<EmployeeUser>{

    Connection connection;

    public EmployeeUserDAO() {
        //TODO
        this.connection = DataSourceService.getConnection();
    }


    @Override
    public void create(EmployeeUser employeeUser) {
        try {
            String sql = "INSERT INTO EmployeeUsers (user_name, email, password, department, account_balance) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, employeeUser.getUsername());
            pstmt.setString(2, employeeUser.getEmail());
            pstmt.setString(3, employeeUser.getPassword());
            pstmt.setString(4, employeeUser.getDepartment());
            pstmt.setInt(5, employeeUser.getAccountBalance());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public EmployeeUser read(int id) {
        EmployeeUser employeeUser = new EmployeeUser();
        try {
            String sql = "SELECT * FROM EmployeeUsers WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet results = pstmt.executeQuery();

            if (results.next()) {
                employeeUser.setUserId(results.getInt("user_id"));
                employeeUser.setUsername(results.getString("user_name"));
                employeeUser.setEmail(results.getString("email"));
                employeeUser.setPassword(results.getString("password"));
                employeeUser.setAccountBalance(results.getInt("account_balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeUser;
    }

    @Override
    public List<EmployeeUser> readAll() {
        List<EmployeeUser> userList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM EmployeeUsers";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet results = pstmt.executeQuery();

            while (results.next()) {
                EmployeeUser employeeUser = new EmployeeUser();
                employeeUser.setUserId(results.getInt("user_id"));
                employeeUser.setUsername(results.getString("user_name"));
                employeeUser.setEmail(results.getString("email"));
                employeeUser.setPassword(results.getString("password"));
                employeeUser.setAccountBalance(results.getInt("account_balance"));
                userList.add(employeeUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void update(EmployeeUser employeeUser) {
        try {
            String sql = "UPDATE EmployeeUsers SET user_name = ?, email = ?, password = ?, department = ?, account_balance = ?, WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, employeeUser.getUsername());
            pstmt.setString(2, employeeUser.getEmail());
            pstmt.setString(3, employeeUser.getPassword());
            pstmt.setString(4, employeeUser.getDepartment());
            pstmt.setInt(5, employeeUser.getAccountBalance());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM EmployeeUser WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
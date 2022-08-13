package com.revatureERS.services;

import com.revatureERS.daos.EmployeeUserDAO;
import com.revatureERS.pojos.EmployeeUser;

import java.util.List;

public class EmployeeUserservice {

    private EmployeeUserDAO dao;

    public EmployeeUserservice() {
        this.dao = new EmployeeUserDAO();
    }

    public void saveEmployeeUser(EmployeeUser employeeUser) {
        dao.create(employeeUser);
    }

    public EmployeeUser getEmployeeUsers(int id) {
        return dao.read(id);
    }
    public EmployeeUser checkEmployeeUser(String email, String password) {
        return dao.logIn(email, password);
    }

    public List<EmployeeUser> getAllEmployeeUsers() {
        return dao.readAll();
    }

    public void updateEmployeeUser(EmployeeUser employeeUser) {
        dao.update(employeeUser);
    }

    public void deleteEmployeeUser(int id) {
        dao.delete(id);
    }


}

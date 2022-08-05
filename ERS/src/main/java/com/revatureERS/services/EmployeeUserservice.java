package com.revatureERS.services;

import com.revatureERS.daos.EmployeeUserDAO;
import com.revatureERS.pojos.EmployeeUser;

import java.util.List;

public class EmployeeUserservice {

    private EmployeeUserDAO dao;

    public EmployeeUserservice() {
        this.dao = new EmployeeUserDAO();
    }

    public void saveEmployeeUser(EmployeeUser user) {
        dao.create(user);
    }

    public EmployeeUser getEmployeeUsers(int id) {
        return dao.read(id);
    }

    public List<EmployeeUser> getAllEmployeeUsers() {
        return dao.readAll();
    }

    public void updateEmployeeUser(EmployeeUser user) {
        dao.update(user);
    }

    public void deleteEmployeeUser(int id) {
        dao.delete(id);
    }

}

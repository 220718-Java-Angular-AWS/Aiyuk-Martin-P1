package com.revatureERS.servlets;

import com.revatureERS.pojos.EmployeeUser;
import com.revatureERS.services.EmployeeUserservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeUserServlet extends HttpServlet {
    EmployeeUserservice service;
    @Override
    public void init() throws ServletException {
        this.service = new EmployeeUserservice();
    }

    @Override
    public void destroy() {
    }
}

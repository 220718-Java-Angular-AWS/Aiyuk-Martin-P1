package com.revatureERS.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureERS.daos.EmployeeUserDAO;
import com.revatureERS.pojos.EmployeeUser;
import com.revatureERS.services.EmployeeUserservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class AuthServlet extends HttpServlet {
    ObjectMapper mapper;
    EmployeeUserservice service;

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        this.mapper = new ObjectMapper();
        this.service = new EmployeeUserservice();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        EmployeeUser employeeUser = service.authenticate(email, password);
        String json = mapper.writeValueAsString(employeeUser);
        resp.getWriter().println(json);

        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}

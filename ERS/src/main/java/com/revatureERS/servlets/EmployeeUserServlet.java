package com.revatureERS.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureERS.pojos.EmployeeUser;
import com.revatureERS.services.EmployeeUserservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


public class EmployeeUserServlet extends HttpServlet {
    EmployeeUserservice service;
    ObjectMapper mapper;
    @Override
    public void init() throws ServletException {
        System.out.println("EmployeeUser servlet initializing...");
        this.service = new EmployeeUserservice();
        this.mapper = new ObjectMapper();
        System.out.println("EmployeeUser servlet initialized!");
    }
    @Override
    public void destroy() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("user-id");
        if(param == null) {
            //Return all
            List<EmployeeUser> userList = service.getAllEmployeeUsers();
            String json = mapper.writeValueAsString(userList);
            resp.getWriter().println(json);
        } else {
            //return the one the request wants
            Integer userId = Integer.parseInt(req.getParameter("user-id"));

            EmployeeUser user = service.getEmployeeUsers(userId);
            String json = mapper.writeValueAsString(user);
            resp.getWriter().println(json);
        }

        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);

//       // Use this method to get all Users
//        List<EmployeeUser> userList = service.getAllEmployeeUsers();
//        String json = mapper.writeValueAsString(userList);
//        resp.getWriter().println(json);
//        resp.setStatus(200);
//        resp.setContentType("Application/Json; Charset=UTF-8");
//        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    StringBuilder builder = new StringBuilder();
    BufferedReader buffer = req.getReader();
        while(buffer.ready()) {
        builder.append(buffer.readLine());
    }
    String json = builder.toString();


    EmployeeUser newUser = mapper.readValue(json, EmployeeUser.class);
        service.saveEmployeeUser(newUser);
}

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

package com.revatureERS.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureERS.pojos.Reimbursement;
import com.revatureERS.services.Reimbursementservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ReimbursementServlet extends HttpServlet {
     Reimbursementservice service;
     ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("Reimbursement servlet initializing...");
        this.service = new Reimbursementservice();
        this.mapper = new ObjectMapper();

        System.out.println("Reimbursement servlet initialized!");

    }
    @Override
    public void destroy() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("reimbursement_id");
        String employeeUsers = req.getParameter("user_id");

        if (param == null && employeeUsers == null) {
            //return all
            List<Reimbursement> reimbursementList = service.getAllReimbursement();
            String json = mapper.writeValueAsString(reimbursementList);
            resp.getWriter().println(json);
        }else if(param != null){
            //return the one the request wants
            Integer reimbursementId = Integer.parseInt(req.getParameter("reimbursement_id"));

            Reimbursement reimbursement = service.getReimbursement(reimbursementId);
            String json = mapper.writeValueAsString(reimbursement);
            resp.getWriter().println(json);
        } else {
            Integer employeeUserId = Integer.parseInt(req.getParameter("user_id"));

            List<Reimbursement> ListReimbursement = service.getAllForUser(employeeUserId);
            String json = mapper.writeValueAsString(ListReimbursement);
            resp.getWriter().println(json);
        }

        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();
        while (buffer.ready()) {
            builder.append(buffer.readLine());
        }
        String json = builder.toString();

        Reimbursement newReimbursement= mapper.readValue(json, Reimbursement.class);
        service.saveReimbursement(newReimbursement);
        resp.setStatus(200);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();
        while (buffer.ready()) {
            builder.append(buffer.readLine());
        }
        String json = builder.toString();

        Reimbursement newReimbursement = mapper.readValue(json, Reimbursement.class);
        service.updateReimbursement(newReimbursement);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("reimbursement_id");

        if(param == null) {
            //return all
            resp.getWriter().println("Unable to delete user as Request ID doesn't exist");
        }else {
            //return the one the request wants
            Integer reimbursementId = Integer.parseInt(req.getParameter("reimbursement_id"));

            service.deleteReimbursement(reimbursementId);

            resp.getWriter().println("Deleted Successfully");
        }

        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);

    }
}

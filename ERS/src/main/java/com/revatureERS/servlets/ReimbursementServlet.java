package com.revatureERS.servlets;

import com.revatureERS.services.Reimbursementservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ReimbursementServlet extends HttpServlet {
    private Reimbursementservice service;

    @Override
    public void init() throws ServletException {
        System.out.println("Reimbursement servlet initializing...");
        this.service = new Reimbursementservice();

        System.out.println("Reimbursement servlet initialized!");

    }
    @Override
    public void destroy() {
    }

}

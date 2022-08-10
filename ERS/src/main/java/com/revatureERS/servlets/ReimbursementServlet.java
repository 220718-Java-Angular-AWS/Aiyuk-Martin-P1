package com.revatureERS.servlets;

import com.revatureERS.services.Reimbursementservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReimbursementServlet extends HttpServlet {
    private Reimbursementservice service;

    @Override
    public void init() throws ServletException {
        this.service = new Reimbursementservice();
    }

    @Override
    public void destroy() {
    }

}

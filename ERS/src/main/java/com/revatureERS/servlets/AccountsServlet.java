package com.revatureERS.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureERS.pojos.Accounts;
import com.revatureERS.pojos.Reimbursement;
import com.revatureERS.services.AccountsService;
import com.revatureERS.services.Reimbursementservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class AccountsServlet extends HttpServlet {

    AccountsService service;

    ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("Accounts servlet initializing...");
        this.service = new AccountsService();
        this.mapper = new ObjectMapper();

        System.out.println("Accounts servlet initialized!");
    }

    @Override
    public void destroy() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("account_id");

        if (param == null) {
            //return all
            List<Accounts> accountsList = service.getAllAccounts();
            String json = mapper.writeValueAsString(accountsList);
            resp.getWriter().println(json);
        }else {
            //return the one the request wants
            Integer reimbursementId = Integer.parseInt(req.getParameter("account_id"));

            int accountId = 0;
            Accounts accounts = service.getAccounts(accountId);
            String json = mapper.writeValueAsString(accounts);
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

        Accounts newAccounts= mapper.readValue(json, Accounts.class);
        service.saveAccounts(newAccounts);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();
        while (buffer.ready()) {
            builder.append(buffer.readLine());
        }
        String json = builder.toString();

        Accounts newAccounts = mapper.readValue(json, Accounts.class);
        service.updateAccounts(newAccounts);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("account_id");

        if(param == null) {
            //return all
            resp.getWriter().println("Unable to delete account as Request ID doesn't exist");
        }else {
            //return the one the request wants
            int accountId = Integer.parseInt(req.getParameter("account_id"));

            service.deleteAccounts(accountId);

            resp.getWriter().println("Deleted Successfully");
        }

        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);

    }
}

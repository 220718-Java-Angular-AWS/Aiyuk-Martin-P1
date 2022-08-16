package com.revatureERS.services;

import com.revatureERS.daos.AccountsDAO;
import com.revatureERS.pojos.Accounts;

import java.util.List;

public class AccountsService {

    private AccountsDAO dao;

    public AccountsService() {
        this.dao = new AccountsDAO();
    }

    public void saveAccounts(Accounts accounts) {
        dao.create(accounts);
    }

    public Accounts getAccounts(int id) {
        return dao.read(id);
    }

    public List<Accounts> getAllAccounts() {
        return dao.readAll();
    }

    public void updateAccounts(Accounts accounts) {
        dao.update(accounts);
    }

    public void deleteAccounts(int accountId) {
        dao.delete(accountId);
    }
}

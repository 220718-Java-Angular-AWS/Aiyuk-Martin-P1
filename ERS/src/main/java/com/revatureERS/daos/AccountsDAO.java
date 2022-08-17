package com.revatureERS.daos;

import com.revatureERS.pojos.Accounts;
import com.revatureERS.services.DataSourceService;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AccountsDAO implements DatasourceCRUD<Accounts> {

    Connection connection;

    public AccountsDAO() {
        this.connection = DataSourceService.getConnection();
    }

    @Override
    public void create(Accounts accounts) {
        try {
            String sql = "INSERT INTO Accounts (account_balance, department) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, accounts.getAccountBalance());
            pstmt.setString(2, accounts.getDepartment());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Accounts read(int id) {
        Accounts account = new Accounts();
        try {
            String sql = "SELECT * FROM Accounts WHERE account_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet results = pstmt.executeQuery();

            if (results.next()) {
                account.setAccountBalance(results.getLong("account_balance"));
                account.setDepartment(results.getString("department"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public List<Accounts> readAll() {
            List<Accounts> accountsList = new LinkedList<>();
            try {
                String sql = "SELECT * FROM accounts";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet results = pstmt.executeQuery();

                while (results.next()) {
                    Accounts accounts = new Accounts();
                    accounts.setAccountBalance(results.getLong("account_balance"));
                    accounts.setDepartment(results.getString("department"));
                    accountsList.add(accounts);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
         return null;
        }

    @Override
    public void update(Accounts accounts) {
        try {
            String sql = "UPDATE Accounts SET account_balance = ?, department = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setLong(1, accounts.getAccountBalance());
            pstmt.setString(2, accounts.getDepartment());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM Accounts WHERE account_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
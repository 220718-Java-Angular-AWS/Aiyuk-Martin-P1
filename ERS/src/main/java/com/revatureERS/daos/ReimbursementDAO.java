package com.revatureERS.daos;

import com.revatureERS.pojos.Reimbursement;
import com.revatureERS.services.DataSourceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ReimbursementDAO implements DatasourceCRUD<Reimbursement> {
    Connection connection;

    public ReimbursementDAO() {
        connection = DataSourceService.getConnection();
    }

    public ReimbursementDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Reimbursement reimbursement) {
        try {
            String sql = "INSERT INTO Reimbursements (ticket_number, ticket_date, amount, reason, user_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, reimbursement.getTicketNumber());
            pstmt.setString(2, reimbursement.getTicketDate());
            pstmt.setInt(3, reimbursement.getAmount());
            pstmt.setString(4, reimbursement.getReason());
            pstmt.setInt(5, reimbursement.getUserID());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Reimbursement read(int id) {
        Reimbursement reimbursement = new Reimbursement();
        try {
            String sql = "SELECT * FROM Reimbursements WHERE reimbursement_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet results = pstmt.executeQuery();

            if (results.next()) {
                reimbursement.setReimbursementId(results.getInt("reimbursement_id"));
                reimbursement.setTicketNumber(results.getInt("ticket_number"));
                reimbursement.setTicketDate(results.getString("ticket_date"));
                reimbursement.setAmount(results.getInt("amount"));
                reimbursement.setReason(results.getString("reason"));
                reimbursement.setStatus(results.getString("status"));
                reimbursement.setUserID(results.getInt("user_id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursement;
    }

    @Override
    public List<Reimbursement> readAll() {
        List<Reimbursement> reimbursementList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM Reimbursements";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet results = pstmt.executeQuery();

            while (results.next()) {
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementId(results.getInt("reimbursement_id"));
                reimbursement.setTicketNumber(results.getInt("ticket_number"));
                reimbursement.setTicketDate(results.getString("ticket_date"));
                reimbursement.setAmount(results.getInt("amount"));
                reimbursement.setReason(results.getString("reason"));
                reimbursement.setStatus(results.getString("status"));
                reimbursement.setUserID(results.getInt("user_id"));
                reimbursementList.add(reimbursement);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementList;
    }

    @Override
    public void update(Reimbursement reimbursement) {
        try {
            String sql = "UPDATE Reimbursements SET ticket_number = ?, ticket_date = ?, amount = ?, reason = ?, status = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, reimbursement.getTicketNumber());
            pstmt.setString(2, reimbursement.getTicketDate());
            pstmt.setInt(3, reimbursement.getAmount());
            pstmt.setString(4, reimbursement.getReason());
            pstmt.setString(5, reimbursement.getStatus());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM Reimbursements WHERE reimbursement_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Reimbursement> employeeUserOnly(Integer employeeUsers) {
        List<Reimbursement> reimbursementList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM Reimbursements WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, employeeUsers);
            ResultSet results = pstmt.executeQuery();

            while (results.next()) {
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementId(results.getInt("reimbursement_id"));
                reimbursement.setTicketNumber(results.getInt("ticket_number"));
                reimbursement.setTicketDate(results.getString("ticket_date"));
                reimbursement.setAmount(results.getInt("amount"));
                reimbursement.setReason(results.getString("reason"));
                reimbursement.setStatus(results.getString("status"));
                reimbursement.setUserID(results.getInt("user_id"));
                reimbursementList.add(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementList;
    }
}

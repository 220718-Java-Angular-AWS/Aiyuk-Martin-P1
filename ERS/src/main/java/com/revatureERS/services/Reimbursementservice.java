package com.revatureERS.services;

import com.revatureERS.daos.ReimbursementDAO;
import com.revatureERS.pojos.Reimbursement;

import java.util.List;

public class Reimbursementservice {

    private ReimbursementDAO dao;

    public Reimbursementservice(ReimbursementDAO dao) {
        this.dao = new ReimbursementDAO();
    }

    public void saveReimbursement(Reimbursement reimbursement) {
        dao.create(reimbursement);
    }

    public Reimbursement getReimbursement(int id) {
        return dao.read(id);
    }

    public List<Reimbursement> getAllReimbursement() {
        return dao.readAll();
    }

    public void updateReimbursement(Reimbursement reimbursement) {
        dao.update(reimbursement);
    }

    public void deleteReimbursement(int id) {
        dao.delete(id);
    }
}

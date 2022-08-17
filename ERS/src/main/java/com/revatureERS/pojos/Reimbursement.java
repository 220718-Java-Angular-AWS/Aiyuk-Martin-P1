package com.revatureERS.pojos;

import java.sql.Timestamp;
import java.util.Objects;
//work with the date/time data types found in the java.time, including LocalDate, LocalTime, LocalDateTime, ZonedDateTime, Period.

public class Reimbursement {

    private int reimbursementId;
    private int ticketNumber;
    private String ticketDate;
    private int amount;
    private String reason;
    private String status;
    private int userID;

    public Reimbursement() {
    }

    public Reimbursement(int reimbursementId, int ticketNumber, String ticketDate, int amount, String reason, String status, int userID) {
        this.reimbursementId = reimbursementId;
        this.ticketNumber = ticketNumber;
        this.ticketDate = ticketDate;
        this.amount = amount;
        this.reason = reason;
        this.status = status;
        this.userID = userID;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserID(int userID) { this.userID = userID; }

    public int getUserID() { return userID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return reimbursementId == that.reimbursementId && ticketNumber == that.ticketNumber && ticketDate == that.ticketDate && amount == that.amount && Objects.equals(reason, that.reason) && Objects.equals(status, that.status) && Objects.equals(userID, that.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbursementId, ticketNumber, ticketDate, amount, reason, status, userID);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", ticketNumber=" + ticketNumber +
                ", ticketDate='" + ticketDate + '\'' +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", userID=" + userID +
                '}';
    }
}


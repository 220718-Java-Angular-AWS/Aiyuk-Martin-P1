package com.revatureERS.pojos;

import java.util.Objects;

public class Accounts {

    private long AccountBalance;

    protected String department;

    public Accounts() {
    }

    public Accounts(long accountBalance, String department) {
        this.AccountBalance = accountBalance;
        this.department = department;
    }

    public long getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        AccountBalance = accountBalance;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return AccountBalance == accounts.AccountBalance && Objects.equals(department, accounts.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AccountBalance, department);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "AccountBalance=" + AccountBalance +
                ", department='" + department + '\'' +
                '}';
    }
}

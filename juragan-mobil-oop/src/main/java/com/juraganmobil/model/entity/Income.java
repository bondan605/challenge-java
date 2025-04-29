package com.juraganmobil.model.entity;

import java.util.Date;

public class Income {
    private Date transactionDate;
    private double total;

    public Income(Date transactionDate, double total) {
        this.transactionDate = transactionDate;
        this.total = total;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Date: " + transactionDate + ", Total: " + total;
    }
}

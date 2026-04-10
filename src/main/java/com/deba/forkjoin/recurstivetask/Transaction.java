package com.deba.forkjoin.recurstivetask;

public class Transaction {

    private long id;
    private String userId;
    private double amount;
    private String category;

    public Transaction(long id, String userId, double amount, String category) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

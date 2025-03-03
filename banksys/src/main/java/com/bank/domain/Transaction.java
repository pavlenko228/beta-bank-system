package com.bank.domain;

public class Transaction {
    private Account account;
    private double amount;
    private OperationType operationType;

    public Transaction(Account account, double amount, OperationType operationType) {
        System.out.println("successfull create transaction");
        this.account = account;
        this.amount = amount;
        this.operationType = operationType;
    }

    @Override 
    public String toString() {
            return String.format("Transaction{account=%s, amount=%.2f, operationType=%.s}", 
                                account, amount, operationType);
    }
}

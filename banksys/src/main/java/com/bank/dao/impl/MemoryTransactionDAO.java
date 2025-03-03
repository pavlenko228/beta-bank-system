package com.bank.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bank.dao.TransactionDAO;
import com.bank.domain.Transaction;

public class MemoryTransactionDAO implements TransactionDAO {
    private final List<Transaction> transactions = new ArrayList<>();

    @Override 
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override 
    public void addTransaction(Transaction transaction) {
        System.out.println("allready there");
        transactions.add(transaction);
    }
}

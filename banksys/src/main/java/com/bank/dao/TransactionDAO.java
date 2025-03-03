package com.bank.dao;

import java.util.List;

import com.bank.domain.Transaction;

public interface TransactionDAO {
    public List<Transaction> getTransactions();

    public void addTransaction(Transaction transaction);
}

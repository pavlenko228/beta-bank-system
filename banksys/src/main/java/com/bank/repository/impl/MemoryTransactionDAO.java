package com.bank.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.model.TransactionDTO;
import com.bank.repository.TransactionDAO;

@Repository
public class MemoryTransactionDAO implements TransactionDAO {
    private final List<TransactionDTO> transactions = new ArrayList<>();

    @Override 
    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    @Override 
    public void addTransaction(TransactionDTO transaction) {
        System.out.println("allready there");
        transactions.add(transaction);
    }
}

package com.bank.repository;

import java.util.List;

import com.bank.model.TransactionDTO;

public interface TransactionDAO {
    public List<TransactionDTO> getTransactions();

    public void addTransaction(TransactionDTO transaction);
}

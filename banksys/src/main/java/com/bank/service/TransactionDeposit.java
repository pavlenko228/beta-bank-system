package com.bank.service;

import com.bank.dao.TransactionDAO;
import com.bank.domain.Account;
import com.bank.domain.OperationType;
import com.bank.domain.Transaction;

public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(Account account, double deposit) {
        System.out.println("call in transaction deposit");
        accountDepositService.deposit(account, deposit);
        Transaction transaction = new Transaction(account, deposit, OperationType.DEPOSIT);
        transactionDAO.addTransaction(transaction);
    }
}

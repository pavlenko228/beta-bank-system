package com.bank.service;

import com.bank.dao.TransactionDAO;
import com.bank.domain.Account;
import com.bank.domain.OperationType;
import com.bank.domain.Transaction;

public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDAO transactionDAO;
    
    public TransactionWithdraw(AccountWithdrawService accountWithdrawService,
                               TransactionDAO transactionDAO) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(Account account, double amount) {
        accountWithdrawService.deposit(account, amount);
        Transaction transaction = new Transaction(account, amount, OperationType.WITHDRAW);
        transactionDAO.addTransaction(transaction);
    }
}

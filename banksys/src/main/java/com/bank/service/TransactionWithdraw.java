package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.model.AccountDTO;
import com.bank.model.OperationType;
import com.bank.model.TransactionDTO;
import com.bank.repository.TransactionDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionWithdraw {
    private final AccountWithdrawService accountWithdrawService;
    private final TransactionDAO transactionDAO;

    public void execute(AccountDTO account, double amount) {
        accountWithdrawService.deposit(account, amount);
        TransactionDTO transaction = new TransactionDTO(account, amount, OperationType.WITHDRAW);
        transactionDAO.addTransaction(transaction);
    }
}

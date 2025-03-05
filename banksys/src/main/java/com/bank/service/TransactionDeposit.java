package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.model.AccountDTO;
import com.bank.model.OperationType;
import com.bank.model.TransactionDTO;
import com.bank.repository.TransactionDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionDeposit {
    private final AccountDepositService accountDepositService;
    private final TransactionDAO transactionDAO;

    public void execute(AccountDTO account, double deposit) {
        System.out.println("call in transaction deposit");
        accountDepositService.deposit(account, deposit);
        TransactionDTO transaction = new TransactionDTO(account, deposit, OperationType.DEPOSIT);
        transactionDAO.addTransaction(transaction);
    }
}

package com.bank.contoroller;

import com.bank.service.AccountListingService;
import com.bank.service.TransactionDeposit;
import com.bank.view.WithdrawDepositOperationCLIUI;

import java.util.List;

import com.bank.domain.Account;
import com.bank.domain.AccountType;


public class TransactionDepositCLI {
    private TransactionDeposit transationDeposit;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListingService;

    public TransactionDepositCLI(TransactionDeposit transationDeposit,
                                WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                AccountListingService accountListingService) {
        this.transationDeposit = transationDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    public void depositMoney(String clientID) {
        List<Account> accountsList = accountListingService.getClientAccountsByType(clientID, AccountType.SAVING);
        if (accountsList.size() > 0) {
            System.out.println("all good");
            transationDeposit.execute(accountsList.get(0), withdrawDepositOperationCLIUI.requestClientAmount());
        }
    }
}

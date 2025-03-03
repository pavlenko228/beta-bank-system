package com.bank.contoroller;

import java.util.List;

import com.bank.domain.Account;
import com.bank.domain.AccountType;
import com.bank.service.AccountListingService;
import com.bank.service.TransactionWithdraw;
import com.bank.view.WithdrawDepositOperationCLIUI;

public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListingService;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw,
                                 WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                 AccountListingService accountListingService) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    public void withdrawMoney(String clientID) {
        List<Account> accounts = accountListingService.getClientAccountsByType(clientID, AccountType.SAVING);
        if (accounts.size() > 0) {
            transactionWithdraw.execute(accounts.get(0), withdrawDepositOperationCLIUI.requestClientAmount());
        } 
    }
}

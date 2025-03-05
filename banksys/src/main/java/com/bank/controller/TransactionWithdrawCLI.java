package com.bank.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.model.AccountDTO;
import com.bank.model.AccountType;
import com.bank.service.AccountListingService;
import com.bank.service.TransactionWithdraw;
import com.bank.view.WithdrawDepositOperationCLIUI;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TransactionWithdrawCLI {
    private final TransactionWithdraw transactionWithdraw;
    private final WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private final AccountListingService accountListingService;

    public void withdrawMoney(String clientID) {
        List<AccountDTO> accounts = accountListingService.getClientAccountsByType(clientID, AccountType.SAVING);
        if (accounts.size() > 0) {
            transactionWithdraw.execute(accounts.get(0), withdrawDepositOperationCLIUI.requestClientAmount());
        } 
    }
}

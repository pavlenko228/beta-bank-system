package com.bank.controller;

import com.bank.model.AccountDTO;
import com.bank.model.AccountType;
import com.bank.service.AccountListingService;
import com.bank.service.TransactionDeposit;
import com.bank.view.WithdrawDepositOperationCLIUI;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionDepositCLI {
    private final TransactionDeposit transationDeposit;
    private final WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private final AccountListingService accountListingService;

    public void depositMoney(String clientID) {
        List<AccountDTO> accountsList = accountListingService.getClientAccountsByType(clientID, AccountType.SAVING);
        if (accountsList.size() > 0) {
            System.out.println("all good");
            transationDeposit.execute(accountsList.get(0), withdrawDepositOperationCLIUI.requestClientAmount());
        }
    }
}

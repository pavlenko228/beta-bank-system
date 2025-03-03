package com.bank.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bank.dao.AccountDAO;
import com.bank.domain.Account;
import com.bank.domain.AccountType;
import com.bank.domain.AccountWithdraw;

public class MemoryAccountDAO implements AccountDAO {
    private final List<Account> accountList = new ArrayList<>();

    @Override 
    public List<Account> getClientAccounts(String clientID) {
        return accountList.stream()
                        .filter(account -> account.getClientID().equals(clientID))
                        .toList();
    }

    @Override
    public void createNewAccount(Account account) {
        accountList.add(account);
        System.out.println("data added");
    }

    @Override 
    public void updateAccount(Account account, double amount) {
        System.out.println("update account balance");
        accountList.stream()
                    .filter(a -> a.equals(account))
                    .findFirst()
                    .ifPresent(a -> a.setBalance(amount));
        System.out.println(accountList);
    }

    @Override 
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        System.out.println(accountList);
        return accountList.stream()
                            .filter(account -> account.getClientID().equals(clientID))
                            .filter(account -> account.getAccountType().equals(accountType))
                            .toList();
    }

    @Override 
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return accountList.stream()
                            .filter(account -> account.getClientID().equals(clientID))
                            .filter(account -> account.getId().equals(accountID))
                            .filter(Account::isWithdrawAllowed)
                            .map(account -> (AccountWithdraw) account)
                            .findFirst()
                            .orElse(null);
    }
    
    @Override 
    public Account getClientAccount(String clientID, String accountID) {
        return accountList.stream()
                            .filter(account -> account.getClientID().equals(clientID))
                            .filter(account -> account.getId().equals(accountID))
                            .findFirst()
                            .orElse(null);
    }
}

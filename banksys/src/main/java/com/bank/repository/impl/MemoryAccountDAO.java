package com.bank.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.model.AccountDTO;
import com.bank.model.AccountType;
import com.bank.model.AccountWithdraw;
import com.bank.repository.AccountDAO;

@Repository
public class MemoryAccountDAO implements AccountDAO {
    private final List<AccountDTO> accountList = new ArrayList<>();

    @Override 
    public List<AccountDTO> getClientAccounts(String clientID) {
        return accountList.stream()
                        .filter(account -> account.getClientID().equals(clientID))
                        .toList();
    }

    @Override
    public void createNewAccount(AccountDTO account) {
        accountList.add(account);
        System.out.println("data added");
    }

    @Override 
    public void updateAccount(AccountDTO account, double amount) {
        System.out.println("update account balance");
        accountList.stream()
                    .filter(a -> a.equals(account))
                    .findFirst()
                    .ifPresent(a -> a.setBalance(amount));
        System.out.println(accountList);
    }

    @Override 
    public List<AccountDTO> getClientAccountsByType(String clientID, AccountType accountType) {
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
                            .filter(AccountDTO::isWithdrawAllowed)
                            .map(account -> (AccountWithdraw) account)
                            .findFirst()
                            .orElse(null);
    }
    
    @Override 
    public AccountDTO getClientAccount(String clientID, String accountID) {
        return accountList.stream()
                            .filter(account -> account.getClientID().equals(clientID))
                            .filter(account -> account.getId().equals(accountID))
                            .findFirst()
                            .orElse(null);
    }
}

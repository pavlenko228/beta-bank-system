package com.bank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.model.AccountDTO;
import com.bank.model.AccountType;
import com.bank.model.AccountWithdraw;
import com.bank.repository.AccountDAO;
import com.bank.service.AccountListingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountListingServiceImpl implements AccountListingService {

    private final AccountDAO accountDAO;

    @Override
    public AccountDTO getClientAccount(String clientID, String accountID) {
        return accountDAO.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return accountDAO.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<AccountDTO> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<AccountDTO> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDAO.getClientAccountsByType(clientID, accountType);
    }
}
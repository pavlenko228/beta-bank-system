package com.bank.service;

import com.bank.model.AccountType;

public interface AccountCreationService {
    public void create(AccountType accountType, String clientID, String accountID);
}

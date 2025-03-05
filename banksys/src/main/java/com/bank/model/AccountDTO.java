package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {
    private AccountType accountType;
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;
}

package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionDTO {
    private AccountDTO account;
    private double amount;
    private OperationType operationType;
}

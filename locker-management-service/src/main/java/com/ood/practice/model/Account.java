package com.ood.practice.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Account {

    private String accountId;

    private String ownerName;

    private AccountLockerPolicy accountLockerPolicy;

    private BigDecimal usageCharges;

    public Account(String accountId, String ownerName, AccountLockerPolicy accountLockerPolicy) {
        this.accountId = accountId;
        this.ownerName = ownerName;
        this.accountLockerPolicy = accountLockerPolicy;
        this.usageCharges = new BigDecimal("0.00");
    }
}

package com.ood.practice.service;

import com.ood.practice.model.Account;

import java.math.BigDecimal;

public class AccountService implements IAccountService {

    private Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    /**
     * @param amount
     * @return
     */
    @Override
    public void addUsageChargeToAccount(BigDecimal amount) {
        account.getUsageCharges().add(amount);
    }
}

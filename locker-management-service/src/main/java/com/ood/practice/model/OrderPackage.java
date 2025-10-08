package com.ood.practice.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderPackage {

    private String orderId;

    private Account userAccount;

    private ShippingStatus shippingStatus;

    private BigDecimal length;

    private BigDecimal width;

    private BigDecimal height;


    public OrderPackage(String orderId, Account userAccount, BigDecimal length, BigDecimal width, BigDecimal height) {
        this.orderId = orderId;
        this.userAccount = userAccount;
        this.length = length;
        this.width = width;
        this.height = height;
        this.shippingStatus = ShippingStatus.CREATED;
    }
}

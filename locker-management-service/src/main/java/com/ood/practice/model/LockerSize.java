package com.ood.practice.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum LockerSize {

    SMALL("Small", new BigDecimal(5.00), new BigDecimal(10.00) , new BigDecimal(10.00), new BigDecimal(10.00)),
    MEDIUM("Medium", new BigDecimal(10.00), new BigDecimal(20.00), new BigDecimal(20.00), new BigDecimal(20.00)),
    LARGE("Large", new BigDecimal(15.00), new BigDecimal(30.00), new BigDecimal(30.00), new BigDecimal(30.00));

    final String size;

    final BigDecimal baseCharges;

    final BigDecimal height;

    final BigDecimal width;

    final BigDecimal length;

   LockerSize(String size, BigDecimal baseCharges, BigDecimal height, BigDecimal width, BigDecimal length) {
       this.size = size;
       this.baseCharges = baseCharges;
       this.height = height;
       this.width = width;
       this.length = length;
   }

}

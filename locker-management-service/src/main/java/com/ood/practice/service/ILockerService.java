package com.ood.practice.service;

import com.ood.practice.model.OrderPackage;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public interface ILockerService {

    void assignPackage(OrderPackage orderPackage, LocalDate assignmentDate);

    void unAssignPackage();

    boolean validateAccessCode(String accessCode);

    boolean isLockerAvailable();

    BigDecimal getStorageCharges();
}

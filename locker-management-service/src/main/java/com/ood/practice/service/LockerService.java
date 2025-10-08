package com.ood.practice.service;

import com.ood.practice.exception.StoragePeriodExpiredException;
import com.ood.practice.model.AccountLockerPolicy;
import com.ood.practice.model.Locker;
import com.ood.practice.model.OrderPackage;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class LockerService implements ILockerService {

    private Locker locker;

    public LockerService(Locker locker) {
        this.locker = locker;
    }

    /**
     * @param orderPackage
     * @param assignmentDate
     */
    @Override
    public void assignPackage(OrderPackage orderPackage, LocalDate assignmentDate) {
        locker.setOrderPackage(orderPackage);
        locker.setAssignedDate(assignmentDate);
        locker.setAccessCode(generateAccessCode());
    }

    /**
     *
     */
    @Override
    public void unAssignPackage() {
        locker.setOrderPackage(null);
        locker.setAssignedDate(null);
        locker.setAccessCode(null);
    }

    /**
     * @param accessCode
     * @return
     */
    @Override
    public boolean validateAccessCode(String accessCode) {
        return locker.getAccessCode().equals(accessCode);
    }

    /**
     * @return
     */
    @Override
    public boolean isLockerAvailable() {
        return locker.getOrderPackage() == null;
    }

    /**
     * @return finalCharge for storage in Locker
     */
    @Override
    public BigDecimal getStorageCharges() {
        OrderPackage currentPkg = locker.getOrderPackage();
        if(currentPkg == null) {
            return new BigDecimal("0.00");
        }
        long totalUseDays = ChronoUnit.DAYS.between( LocalDate.now(), locker.getAssignedDate());
        AccountLockerPolicy userLockerPolicy = currentPkg.getUserAccount().getAccountLockerPolicy();
        if(totalUseDays > userLockerPolicy.getMaxUsageDays()) {
            throw new StoragePeriodExpiredException("Package has expired maximum storage period of " + userLockerPolicy.getMaxUsageDays());
        }
        long chargeableDays = Math.max(0, totalUseDays - userLockerPolicy.getFreeUsageDays());
        BigDecimal finalCharges = locker.getLockerSize().getBaseCharges().multiply(BigDecimal.valueOf(chargeableDays));

        return finalCharges;
    }

    private String generateAccessCode(){
        return UUID.randomUUID().toString();
    }
}

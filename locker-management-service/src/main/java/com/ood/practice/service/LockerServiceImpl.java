package com.ood.practice.service;

import com.ood.practice.model.OrderPackage;

import java.math.BigDecimal;
import java.util.Date;

public class LockerServiceImpl implements ILockerService{
    /**
     * @param orderPackage
     * @param assignmentDate
     */
    @Override
    public void assignPackage(OrderPackage orderPackage, Date assignmentDate) {

    }

    /**
     *
     */
    @Override
    public void unAssignPackage() {

    }

    /**
     * @param accessCode
     * @return
     */
    @Override
    public boolean validateAccessCode(String accessCode) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean isLockerAvailable() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public BigDecimal getStorageCharges() {
        return null;
    }
}

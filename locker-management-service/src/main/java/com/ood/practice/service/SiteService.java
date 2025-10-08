package com.ood.practice.service;

import com.ood.practice.model.Locker;
import com.ood.practice.model.LockerSize;
import com.ood.practice.model.OrderPackage;

import java.util.Date;

public class SiteService implements ISiteService {

    /**
     * @param lockerSize
     * @return
     */
    @Override
    public Locker findAvailableLocker(LockerSize lockerSize) {

        return null;
    }

    /**
     * @param orderPackage
     * @param date
     * @return
     */
    @Override
    public Locker placePackageInLocker(OrderPackage orderPackage, Date date) {

        return null;
    }
}

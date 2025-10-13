package com.ood.practice.service;

import com.ood.practice.model.Locker;
import com.ood.practice.model.LockerSize;
import com.ood.practice.model.OrderPackage;

import java.time.LocalDate;
import java.util.Date;

public interface ISiteService {

    Locker findAvailableLocker(LockerSize lockerSize);

    Locker placePackageInLocker(OrderPackage orderPackage, LocalDate date);

}

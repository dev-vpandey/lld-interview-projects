package com.ood.practice.service;

import com.ood.practice.model.Account;
import com.ood.practice.model.Locker;
import com.ood.practice.model.OrderPackage;
import com.ood.practice.model.Site;

import java.util.Map;

public class LockerManagerFacade {

    private Site site;

    private INotificationService notificationService;

    private Map<String, Account> accountIdToAccountMap;

    private Map<String, Locker> accessCodeToLockerMap;

    public LockerManagerFacade(Site site) {
        this.site = site;
    }

    public void putPackageInLocker(OrderPackage orderPackage) {
        
    }

}

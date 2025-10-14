package com.ood.practice.service;

import com.ood.practice.exception.StoragePeriodExpiredException;
import com.ood.practice.model.Account;
import com.ood.practice.model.Locker;
import com.ood.practice.model.OrderPackage;
import com.ood.practice.model.ShippingStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class LockerManagerFacade {

    private ISiteService siteService;

    private INotificationService notificationService;

    private IAccountService accountService;

    private ILockerService lockerService;

    private IOrderPackageService orderPackageService;

    private Map<String, Account> accountIdToAccountMap;

    private Map<String, Locker> accessCodeToLockerMap;

    public LockerManagerFacade(ISiteService siteService,
                               INotificationService notificationService,
                               IAccountService accountService,
                               ILockerService lockerService,
                               IOrderPackageService orderPackageService) {
        this.siteService = siteService;
        this.notificationService = notificationService;
        this.accountService = accountService;
        this.lockerService = lockerService;
        this.orderPackageService = orderPackageService;
    }

    public Locker putPackageInLocker(OrderPackage orderPackage, LocalDate assignmentDate) {
       Locker locker = siteService.placePackageInLocker(orderPackage, assignmentDate);
       if(locker != null) {
           notificationService.sendNotification("Package placed in Locker, use code "
                           + locker.getAccessCode() + " to retrieve it",
                   orderPackage.getUserAccount());
           accessCodeToLockerMap.put(locker.getAccessCode(), locker);
       }
       return locker;
    }

    public Locker retrievePackageInLocker(String accessCode) {
        Locker locker = accessCodeToLockerMap.get(accessCode);
        if(locker != null && locker.getAccessCode().equals(accessCode)) {
            try {
                BigDecimal lockerCharge = lockerService.getStorageCharges();
                accountService.addUsageChargeToAccount(lockerCharge);
                orderPackageService.updateShippingStatus(ShippingStatus.RETRIEVED);
                lockerService.unAssignPackage();
                accountIdToAccountMap.remove(accessCode);
            } catch (StoragePeriodExpiredException spe) {
                lockerService.unAssignPackage();
            }
        }
        return locker;
    }
}

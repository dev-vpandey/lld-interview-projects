package com.ood.practice.service;

import com.ood.practice.exception.NoLockerAvailableException;
import com.ood.practice.model.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
public class SiteService implements ISiteService {

    private Site site;

    private ILockerService lockerService;

    private IOrderPackageService orderPackageService;

    /**
     * @param lockerSize
     * @return
     */
    @Override
    public Locker findAvailableLocker(LockerSize lockerSize) {
        Set<Locker> lockers = site.getSizeToLockersMap().get(lockerSize);
        for(Locker locker : lockers) {
            if(lockerService.isLockerAvailable()) {
                return locker;
            }
        }
        return null;
    }

    /**
     * @param orderPackage
     * @param date
     * @return
     */
    @Override
    public Locker placePackageInLocker(OrderPackage orderPackage, LocalDate date) {
        LockerSize size = orderPackageService.getLockerSizeToFitPackage();
        Locker locker = findAvailableLocker(size);
        if(locker != null) {
            lockerService.assignPackage(orderPackage, date);
            orderPackageService.updateShippingStatus(ShippingStatus.IN_LOCKER);
            return locker;
        }
       throw new NoLockerAvailableException("No available locker for this package");
    }
}

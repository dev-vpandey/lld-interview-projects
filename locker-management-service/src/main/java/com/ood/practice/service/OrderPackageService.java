package com.ood.practice.service;

import com.ood.practice.exception.PackageIncompatibleException;
import com.ood.practice.model.LockerSize;
import com.ood.practice.model.OrderPackage;
import com.ood.practice.model.ShippingStatus;

public class OrderPackageService implements IOrderPackageService {

    private OrderPackage orderPackage;

    public OrderPackageService(OrderPackage orderPackage) {
        this.orderPackage = orderPackage;
    }

    /**
     * @param shippingStatus
     */
    @Override
    public void updateShippingStatus(ShippingStatus shippingStatus) {
        orderPackage.setShippingStatus(shippingStatus);
    }

    /**
     * @return
     */
    @Override
    public LockerSize getLockerSizeToFitPackage() {
        for(LockerSize size : LockerSize.values()) {
            if(size.getWidth().compareTo(orderPackage.getWidth()) >= 0 ||
                    size.getHeight().compareTo(orderPackage.getHeight()) >= 0 ||
                    size.getLength().compareTo(orderPackage.getLength()) >= 0) {
                    return size;
            }
        }
        throw new PackageIncompatibleException("No Locker of this size is available");
    }
}

package com.ood.practice.service;

import com.ood.practice.model.LockerSize;
import com.ood.practice.model.ShippingStatus;

public interface IOrderPackageService {

    void updateShippingStatus(ShippingStatus shippingStatus);

    LockerSize getLockerSizeToFitPackage();
}

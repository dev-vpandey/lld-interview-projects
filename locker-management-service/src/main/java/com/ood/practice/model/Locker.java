package com.ood.practice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Locker {

    private LockerSize lockerSize;

    private OrderPackage orderPackage;

    private LocalDate assignedDate;

    private String accessCode;

    public Locker(LockerSize lockerSize) {
        this.lockerSize = lockerSize;
    }

}

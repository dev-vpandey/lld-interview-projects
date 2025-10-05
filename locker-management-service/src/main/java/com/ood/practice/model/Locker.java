package com.ood.practice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Locker {

    private LockerSize lockerSize;

    private OrderPackage orderPackage;

    private LocalDateTime assignedDate;

    private String accessCode;

    public Locker(LockerSize lockerSize) {
        this.lockerSize = lockerSize;
    }

}

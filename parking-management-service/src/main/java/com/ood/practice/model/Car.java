package com.ood.practice.model;

public class Car implements IVehicle {

    private int licensePlateNumber;

    public Car(int licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    @Override
    public int getLicencePlateNumber() {
        return this.licensePlateNumber;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.MEDIUM;
    }
}

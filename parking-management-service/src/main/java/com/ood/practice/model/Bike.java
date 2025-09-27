package com.ood.practice.model;

public class Bike implements IVehicle {

    private int licensePlateNumber;

    public Bike(int licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    @Override
    public int getLicencePlateNumber() {
        return this.licensePlateNumber;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.SMALL;
    }
}

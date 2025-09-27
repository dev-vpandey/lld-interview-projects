package com.ood.practice.model;

public class Truck implements IVehicle {

    private int licensePlateNumber;

    public Truck (int licensePlateNumber) {
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

package com.ood.practice.model;

public interface IParkingSpot {

    public boolean isAvailable();

    public void occupy(IVehicle vehicle);

    public void vacate();

    public int getSpotNumber();

    public VehicleSize getSize();
}

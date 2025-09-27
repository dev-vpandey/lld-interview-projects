package com.ood.practice.model;

public class CompactSpot implements IParkingSpot {

    private int spotNumber;

    private IVehicle vehicle;

    public CompactSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicle = null; // Initially this will always be empty
    }
    /**
     * @return
     */
    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    /**
     * @param vehicle
     */
    @Override
    public void occupy(IVehicle vehicle) {
        if(isAvailable()) {
            this.vehicle = vehicle;
        } else {
            // Spot occupied
        }
    }

    /**
     *
     */
    @Override
    public void vacate() {
        this.vehicle = null;
    }

    /**
     * @return
     */
    @Override
    public int getSpotNumber() {
        return this.spotNumber;
    }

    /**
     * @return
     */
    @Override
    public VehicleSize getSize() {
        return VehicleSize.SMALL;
    }
}

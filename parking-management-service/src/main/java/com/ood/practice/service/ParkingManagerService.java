package com.ood.practice.service;

import com.ood.practice.model.IParkingSpot;
import com.ood.practice.model.IVehicle;
import com.ood.practice.model.VehicleSize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManagerService {

    public Map<VehicleSize, List<IParkingSpot>> availableParkingSpots;

    public Map<IVehicle, IParkingSpot> vehicleToSpotMap;

    public Map<IParkingSpot, IVehicle> spotToVehicleMap;

    public ParkingManagerService (Map<VehicleSize, List<IParkingSpot>> availableParkingSpots) {

        this.availableParkingSpots = availableParkingSpots;
        this.vehicleToSpotMap = new HashMap<>();
        this.spotToVehicleMap = new HashMap<>();
    }

    public IParkingSpot findSpotForVehicle(IVehicle vehicle) {

        VehicleSize vehicleSize = vehicle.getVehicleSize();

        for(VehicleSize size : VehicleSize.values()) {
            if(size.compareTo(vehicleSize) >= 0) { // Based on the enum values get the first smallest available spot
                List<IParkingSpot> parkingSpots = availableParkingSpots.get(size);

                return parkingSpots.stream()
                        .filter(IParkingSpot::isAvailable)
                        .findFirst()
                        .orElse(null);
            }
        }
        return null;
    }

    public IParkingSpot parkVehicle(IVehicle vehicle) {

        IParkingSpot parkingSpot = findSpotForVehicle(vehicle);
        if(parkingSpot != null) {
            parkingSpot.occupy(vehicle);
            vehicleToSpotMap.put(vehicle, parkingSpot); // Record where the vehicle is parked
            spotToVehicleMap.put(parkingSpot, vehicle);
            availableParkingSpots.get(parkingSpot.getSize()).remove(parkingSpot); // Remove the spot from the availability
            return parkingSpot;
        } else {
            return  null; // No Spot found
        }
    }

    public void unparkVehicle(IVehicle vehicle) {
        IParkingSpot parkingSpot = vehicleToSpotMap.remove(vehicle);
        spotToVehicleMap.remove(vehicle);
        if(parkingSpot != null) {
            parkingSpot.vacate();
            availableParkingSpots.get(parkingSpot.getSize()).add(parkingSpot); // Add the spot back as its available now
        }
    }

    /**
     * Get which vehicle is parked in the spot
     * @param spot
     * @return
     */
    public IVehicle findVehicleBySpot(IParkingSpot spot) {
        return spotToVehicleMap.get(spot);
    }


    /**
     * Get Spot where the Vehicle is parked
     * @param vehicle
     * @return
     */
    public IParkingSpot findParkingSpotByVehicle(IVehicle vehicle) {
        return vehicleToSpotMap.get(vehicle);
    }
}

package com.ood.practice.service;

import com.ood.practice.model.IParkingSpot;
import com.ood.practice.model.IVehicle;
import com.ood.practice.service.fare.FareCalculatorService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkingLotService {

    private ParkingManagerService parkingManagerService;

    private FareCalculatorService fareCalculatorService;

    public ParkingLotService(ParkingManagerService parkingManagerService, FareCalculatorService fareCalculatorService) {
        this.parkingManagerService = parkingManagerService;
        this.fareCalculatorService = fareCalculatorService;
    }

    /**
     * Method to handle parking of vehicle and issue of ticket when parked
     * @param vehicle
     * @return TicketService
     */
    public TicketService parkVehicle(IVehicle vehicle) {

        IParkingSpot parkingSpot = parkingManagerService.parkVehicle(vehicle);
        if(parkingSpot != null) {
            TicketService ticket = new TicketService(generateTicketId(), vehicle, parkingSpot, LocalDateTime.now());
            return ticket;
        } else {
            return null; // no spot available
        }
    }

    /**
     * Method to handle exit of vehicle and fare collection
     * @param ticket
     */
    public void exitVehicle(TicketService ticket) {

        if(ticket != null && ticket.getExitTime() == null) { // Making sure ticket is valid and vehicle hasn't left

            ticket.setExitTime(LocalDateTime.now());

            parkingManagerService.unparkVehicle(ticket.getVehicle());

            BigDecimal fare = fareCalculatorService.calculateFare(ticket);
        } else {
            // Invalid Ticket or already left vehicle
        }
    }

    private String generateTicketId() {
        return "TICKET" + System.currentTimeMillis();
    }
}

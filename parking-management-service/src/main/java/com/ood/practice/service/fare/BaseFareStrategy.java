package com.ood.practice.service.fare;

import com.ood.practice.service.TicketService;

import java.math.BigDecimal;

public class BaseFareStrategy implements IFareStrategy {

    private static final BigDecimal SMALL_VEHICLE_RATE = new BigDecimal("1.0");

    private static final BigDecimal MEDIUM_VEHICLE_RATE = new BigDecimal("2.0");

    private static final BigDecimal LARGE_VEHICLE_RATE = new BigDecimal("3.0");

    /**
     * @param ticket
     * @param inputFare
     * @return
     */
    @Override
    public BigDecimal calculateFare(TicketService ticket, BigDecimal inputFare) {
        BigDecimal fare = inputFare;
        BigDecimal rate;
        switch (ticket.getVehicle().getVehicleSize()) {
            case MEDIUM:
                rate = MEDIUM_VEHICLE_RATE;
                break;
            case LARGE:
                rate = LARGE_VEHICLE_RATE;
                break;
            default:
                rate = SMALL_VEHICLE_RATE;
        }
        fare = fare.add(rate.multiply(ticket.calculateParkingDuration()));

        return fare;
    }
}

package com.ood.practice.service;

import com.ood.practice.model.IParkingSpot;
import com.ood.practice.model.IVehicle;
import lombok.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class TicketService {

    private String ticketId;

    private IVehicle vehicle;

    private IParkingSpot parkingSpot;

    private final LocalDateTime entryTime;

    private LocalDateTime exitTime;

    public TicketService(String ticketId, IVehicle vehicle, IParkingSpot parkingSpot, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
        this.exitTime = null;
    }

    public BigDecimal calculateParkingDuration() { // get the parking mins between entry time to exit time or
        // the current time to get the bill
        return new BigDecimal(
                Duration.between(this.entryTime, Objects.requireNonNullElseGet(this.exitTime,
                        LocalDateTime::now)).toMinutes());
    }
}

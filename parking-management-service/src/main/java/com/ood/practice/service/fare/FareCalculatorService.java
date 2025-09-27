package com.ood.practice.service.fare;

import com.ood.practice.service.TicketService;

import java.math.BigDecimal;
import java.util.List;

public class FareCalculatorService {

    List<IFareStrategy> fareStrategies;

    public FareCalculatorService(List<IFareStrategy> fareStrategies) {
        this.fareStrategies = fareStrategies;
    }

    public BigDecimal calculateFare(TicketService ticket) {

        BigDecimal fare = BigDecimal.ZERO;

        for (IFareStrategy strategy : fareStrategies) {
            fare = strategy.calculateFare(ticket, fare);
        }
        return fare;
    }
}

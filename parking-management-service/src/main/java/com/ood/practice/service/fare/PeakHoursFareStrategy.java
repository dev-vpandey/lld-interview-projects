package com.ood.practice.service.fare;

import com.ood.practice.service.TicketService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PeakHoursFareStrategy implements IFareStrategy {

    private static final BigDecimal PEAK_HOURS_MULTIPLIER = new BigDecimal("1.5");
    /**
     * @param ticket
     * @param inputFare
     * @return
     */
    @Override
    public BigDecimal calculateFare(TicketService ticket, BigDecimal inputFare) {
        BigDecimal fare = inputFare;
        if(isPeakHoursApplicable(ticket.getEntryTime())) {
            fare = fare.multiply(PEAK_HOURS_MULTIPLIER);
        }
        return fare;
    }

    private boolean isPeakHoursApplicable(LocalDateTime time) {
        int hour = time.getHour();
        return (hour >= 7 && hour <= 10) || (hour >= 16 && hour <= 19);
    }
}

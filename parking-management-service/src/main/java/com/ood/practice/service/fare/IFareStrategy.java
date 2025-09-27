package com.ood.practice.service.fare;

import com.ood.practice.service.TicketService;

import java.math.BigDecimal;

public interface IFareStrategy {

    BigDecimal calculateFare(TicketService ticket, BigDecimal inputFare);
}

package com.ood.practice;

import com.ood.practice.model.*;
import com.ood.practice.service.ParkingLotService;
import com.ood.practice.service.ParkingManagerService;
import com.ood.practice.service.TicketService;
import com.ood.practice.service.fare.BaseFareStrategy;
import com.ood.practice.service.fare.FareCalculatorService;
import com.ood.practice.service.fare.IFareStrategy;
import com.ood.practice.service.fare.PeakHoursFareStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit test for the parking App.
 */
public class ParkingManagementAppTest {

    private static final Logger log = Logger.getLogger(ParkingManagementAppTest.class.getName());
    /**
     *
     */
    @Test
    public void testVehicleJourney() {
        log.info("\n ==== Testing Parking System complete Vehicle Journey ====");

        log.info("\n === Setting up Parking Spots ====");
        Map<VehicleSize, List<IParkingSpot>> availableSpots = new HashMap<>();
        List<IParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new RegularSpot(1));
        parkingSpots.add(new RegularSpot(2));
        availableSpots.put(VehicleSize.MEDIUM, parkingSpots);
        log.info("\n === Created 2 parking Spots for medium-sized vehicles ====");
        log.info("  - Spot 1: Regular parking spot 1");
        log.info("  - Spot 2: Regular parking spot 2");

        log.info("\n--- Initializing Parking Manager ---");
        ParkingManagerService parkingManager = new ParkingManagerService(availableSpots);
        log.info("\n=== Parking Manager Initialized with available spots ====");

        log.info("\n--- Initializing fare calculation system ---");
        List<IFareStrategy> fareStrategies = new ArrayList<>(List.of(new BaseFareStrategy(), new PeakHoursFareStrategy()));
        FareCalculatorService fareCalculatorService = new FareCalculatorService(fareStrategies);
        log.info("\n === Created multiple fare strategies ====");
        log.info("  - Created BaseFareStrategy");
        log.info("  - Created PeakHoursFareStrategy");

        log.info("\n--- Initializing Parking Lot ---");
        ParkingLotService parkingLotService = new ParkingLotService(parkingManager, fareCalculatorService);

        log.info("\n--- Creating test vehicle ---");
        IVehicle car = new Car(123);

        log.info("\n===== Vehicle entering parking lot =========");
        TicketService ticket =  parkingLotService.parkVehicle(car);
        log.info("\n===== ticket generated for vehicle " + ticket.getVehicle().getLicencePlateNumber() + " =========");
        log.info("\n===== Parking spot assigned " + ticket.getParkingSpot().getSpotNumber() + " =========");
        assertNotNull(ticket, "Ticket should not be null"); // Ticket created on successfull parking
        assertEquals(car, ticket.getVehicle(), "Vehicle should be same which enetered");
        assertNotNull(ticket.getParkingSpot(), "Parking Spot should not be null");
        log.info("\n===== Ticket Validation pased =========");
        log.info("\n===== Vehicle matches the one that entered =========");
        log.info("\n===== Parking spot assigned successfully =========");

        log.info("\n===== Find the vehicle in the parking lot =========");
        IParkingSpot foundParkingSpot = parkingManager.findParkingSpotByVehicle(car);
        assertNotNull(foundParkingSpot, "Parking Spot should not be null");
        assertEquals(ticket.getParkingSpot(), foundParkingSpot, "Parking Spot should be same");

        log.info("\n===== Vehicle exiting parking lot =========");
        parkingLotService.exitVehicle(ticket);
        assertNotNull(ticket.getExitTime(), "Exit time should not be null");
        assertTrue(foundParkingSpot.isAvailable(), "Parking Spot should be available");
        log.info("\n===== Vehicle exit passed successfully =========");
        log.info("\n===== Exit time recoreded =========");
        log.info("\n===== Emptied Spot is now available for taking =========");

        log.info("\n ==== Parking System complete Vehicle Journey test completed successfully ====");

    }
}

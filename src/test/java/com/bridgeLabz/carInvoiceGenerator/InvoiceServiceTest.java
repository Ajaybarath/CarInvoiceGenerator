package com.bridgeLabz.carInvoiceGenerator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

    @Test
    public void calculateFareAndCompare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare);
    }

    @Test
    public void calculateFareForMinimumDistanceAndTime() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare);
    }

    @Test
    public void givenMultipleRidesReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };

        InvoiceSummary invoiceSummary = new InvoiceGenerator().calculateFare(rides);

        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);

        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdGetInvoiceSummaryForAllRides() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };

        int userId = 123;

        RideRepository rideRepository = new RideRepository(userId);
        rideRepository.addRide(new Ride(2.0, 5));
        rideRepository.addRide(new Ride(0.1, 1));

        InvoiceSummary invoiceSummary = new InvoiceGenerator().calculateFare(rideRepository);

        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);

        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}

package com.bridgeLabz.carInvoiceGenerator;

public class InvoiceGenerator {

    private static final double MININUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final int MINIMUM_FARE = 5;


    public double calculateFare(double distance, int time) {
        return Math.max (MINIMUM_FARE, (distance * MININUM_COST_PER_KILOMETER  + time * COST_PER_TIME));
    }

    public double calculateFare(Ride[] rides) {

        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }
}

package com.bridgeLabz.carInvoiceGenerator;

public class InvoiceGenerator {

    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final int MINIMUM_FARE = 5;

    private static final double PREMIUM_COST_PER_KILOMETER = 15;
    private static final int PREMIUM_COST_PER_TIME = 2;
    private static final int PREMIUM_MINIMUM_FARE = 20;


    public double calculateFare(double distance, int time, Ride.RideType rideType) {

        if (rideType == Ride.RideType.NORMAL) {
            return Math.max (MINIMUM_FARE, (distance * COST_PER_KILOMETER  + time * COST_PER_TIME));
        }
        else {
            return Math.max (PREMIUM_MINIMUM_FARE, (distance * PREMIUM_COST_PER_KILOMETER  + time * PREMIUM_COST_PER_TIME));
        }
    }

    public InvoiceSummary calculateFare(Ride[] rides) {

        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public InvoiceSummary calculateFare(RideRepository rideRepository) {
        double totalFare = 0;
        for (Ride ride : rideRepository.getRides()) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
        }
        return new InvoiceSummary(rideRepository.getRides().size(), totalFare);
    }
}

package com.bridgeLabz.carInvoiceGenerator;

public class InvoiceGenerator {

    private static final double MININUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;

    public double calculateFare(double distance, int time) {
        return distance * MININUM_COST_PER_KILOMETER  + time * COST_PER_TIME;
    }
}

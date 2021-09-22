package com.bridgeLabz.carInvoiceGenerator;

public class Ride {
    private final double distance;
    private final int time;
    private final RideType rideType;

    public enum RideType{
        NORMAL, PREMIUM
    }

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.rideType = RideType.NORMAL;
    }

    public Ride(double distance, int time, RideType rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public RideType getRideType() {
        return rideType;
    }
}

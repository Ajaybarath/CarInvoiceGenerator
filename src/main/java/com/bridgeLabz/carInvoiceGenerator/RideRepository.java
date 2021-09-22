package com.bridgeLabz.carInvoiceGenerator;

import java.util.ArrayList;
import java.util.List;

public class RideRepository {
    private final int userId;
    private List<Ride> rides;

    public RideRepository(int userId) {
        this.userId = userId;
        this.rides = new ArrayList<Ride>();
    }

    public int getUserId() {
        return userId;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }
}

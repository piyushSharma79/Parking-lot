package com.backend.parkinglot.models;

public class Spot {
    private int id;
    private Vehicle vehicle;
    private VehicleType type;

    public boolean isOccupied(){
        return vehicle != null;
    }

}

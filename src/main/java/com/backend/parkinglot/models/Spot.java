package com.backend.parkinglot.models;

import lombok.Data;

@Data
public class Spot {
    private int id;
    private Vehicle vehicle;
    private VehicleType type;

    public boolean isOccupied(){
        return vehicle != null;
    }

}

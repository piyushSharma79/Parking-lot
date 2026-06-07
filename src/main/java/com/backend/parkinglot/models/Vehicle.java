package com.backend.parkinglot.models;

import lombok.Data;

@Data
public class Vehicle {
    private int id;
    private String RegistrationNumber;
    private VehicleType vehicleType;
    private User user;

}

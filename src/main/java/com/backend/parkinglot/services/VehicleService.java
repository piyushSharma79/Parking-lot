package com.backend.parkinglot.services;

import com.backend.parkinglot.models.Vehicle;
import com.backend.parkinglot.models.VehicleType;

public interface VehicleService {
    public Vehicle createOrGet(String registrationNumber, VehicleType type);
}

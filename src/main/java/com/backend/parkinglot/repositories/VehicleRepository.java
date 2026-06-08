package com.backend.parkinglot.repositories;

import com.backend.parkinglot.models.Vehicle;
import com.backend.parkinglot.models.VehicleType;

public interface VehicleRepository {

    public Vehicle createOrGet(String RegNum, VehicleType type);

}

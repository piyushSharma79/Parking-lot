package com.backend.parkinglot.services;

import com.backend.parkinglot.models.Vehicle;
import com.backend.parkinglot.models.VehicleType;
import com.backend.parkinglot.repositories.VehicleRepository;

public class VehicleServiceImpl implements VehicleService{

    private VehicleRepository vehicleRepository;

    public void VehicleRepository(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createOrGet(String registrationNumber, VehicleType type) {
        return vehicleRepository.createOrGet(registrationNumber, type);
    }
}

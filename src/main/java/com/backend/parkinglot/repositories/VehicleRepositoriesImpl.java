package com.backend.parkinglot.repositories;

import com.backend.parkinglot.models.Vehicle;
import com.backend.parkinglot.models.VehicleType;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VehicleRepositoriesImpl implements VehicleRepository{

    private HashMap<Integer, Vehicle> map;

    public  VehicleRepositoriesImpl(){
        map = new HashMap<>();
    }
    @Override
    public Vehicle createOrGet(String registrationNumber, VehicleType type) { //of exists get else create
        for(Map.Entry<Integer, Vehicle> entry : map.entrySet()){ //entrySet() to iterate over the map
            Vehicle vehicle = entry.getValue();
            if(vehicle.getRegistrationNumber().equals(registrationNumber)){
                return vehicle;
            }
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(type);
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setId(map.size()+1);
        map.put(vehicle.getId(), vehicle);
        return vehicle;
    }
}

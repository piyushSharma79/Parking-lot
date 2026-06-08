package com.backend.parkinglot.strategies;

import com.backend.parkinglot.exceptions.NoSpotAvailableException;
import com.backend.parkinglot.models.Floor;
import com.backend.parkinglot.models.Spot;
import com.backend.parkinglot.models.VehicleType;

import java.util.List;

public interface SpotAssignStrategy {
    public Spot findAvailableSpot(List<Floor> floors, VehicleType type) throws NoSpotAvailableException;
}

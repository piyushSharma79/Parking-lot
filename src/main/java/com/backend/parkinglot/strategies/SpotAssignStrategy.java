package com.backend.parkinglot.strategies;

import com.backend.parkinglot.exceptions.NoSpotAvailableException;
import com.backend.parkinglot.models.Floor;
import com.backend.parkinglot.models.Spot;

import java.util.List;

public interface SpotAssignStrategy {
    public Spot findAvailableSpot(List<Floor> floors) throws NoSpotAvailableException;
}

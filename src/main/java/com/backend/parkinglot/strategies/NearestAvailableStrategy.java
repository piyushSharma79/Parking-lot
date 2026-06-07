package com.backend.parkinglot.strategies;

import com.backend.parkinglot.exceptions.NoSpotAvailableException;
import com.backend.parkinglot.models.Floor;
import com.backend.parkinglot.models.Spot;

import java.util.List;

public class NearestAvailableStrategy implements SpotAssignStrategy {

    @Override
    public Spot findAvailableSpot(List<Floor> floors) throws NoSpotAvailableException {
        for(Floor floor : floors){
            for(Spot spot : floor.getSpots()){
                if(!spot.isOccupied()){
                    return spot;
                }
            }
        }
        throw new NoSpotAvailableException();
    }
}

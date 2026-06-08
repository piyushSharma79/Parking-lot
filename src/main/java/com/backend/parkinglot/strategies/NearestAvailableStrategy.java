package com.backend.parkinglot.strategies;

import com.backend.parkinglot.exceptions.NoSpotAvailableException;
import com.backend.parkinglot.models.Floor;
import com.backend.parkinglot.models.FloorStatus;
import com.backend.parkinglot.models.Spot;
import com.backend.parkinglot.models.VehicleType;

import java.util.List;

public class NearestAvailableStrategy implements SpotAssignStrategy {

    @Override
    public Spot findAvailableSpot(List<Floor> floors, VehicleType type) throws NoSpotAvailableException {
        for(Floor floor : floors){
            if(floor.getFloorStatus() == FloorStatus.OPERATIONAL){
                for(Spot spot : floor.getSpots()){
                    if(!spot.isOccupied() && spot.getType() == type){
                        return spot;
                    }
                }
            }
        }
        throw new NoSpotAvailableException("Parking Spot not available");
    }
}

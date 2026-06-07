package com.backend.parkinglot.repositories;

import com.backend.parkinglot.models.Floor;
import com.backend.parkinglot.models.Gate;
import com.backend.parkinglot.models.ParkingLot;

import java.util.Map;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> map;

    public ParkingLotRepository() {
        this.map = new TreeMap<>();
    }

    public ParkingLotRepository(Map<Integer, ParkingLot> map) {
        this.map = map;
    }

    public ParkingLot getByGateId(int gateId){
        for(Map.Entry<Integer, ParkingLot> entry: map.entrySet()){
            ParkingLot parkingLot = entry.getValue();
            for(Floor floor : parkingLot.getFloors()){
                for(Gate gate : floor.getGates()){
                    if(gate.getId() == gateId){
                        return parkingLot;
                    }
                }
            }
        }
        return null;
    }
}

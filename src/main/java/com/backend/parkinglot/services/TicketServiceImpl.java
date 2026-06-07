package com.backend.parkinglot.services;

import com.backend.parkinglot.models.ParkingLot;
import com.backend.parkinglot.models.Ticket;
import com.backend.parkinglot.models.Vehicle;
import com.backend.parkinglot.models.VehicleType;
import com.backend.parkinglot.repositories.ParkingLotRepository;

public class TicketServiceImpl implements TicketService{
    private VehicleService vehicleService;
    private ParkingLotRepository parkingLotRepository;

    public TicketServiceImpl(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @Override
    public Ticket generateTicket(String registration, int gateId, VehicleType vehicleType) {

        /*
        step#1: Create or get the vehicle
        step#2: Get the parkin lot obj via gateId
        step#3: Find the spot for parking. If nothing available, then throw an exception
        Else take the spot and assign it to the vehicle
        step#4: Create the ticket and return it
         */
        Vehicle vehicle = vehicleService.createOrGet(registration, vehicleType);
        ParkingLot parkingLot = parkingLotRepository.getByGateId(gateId);

        return null;
    }
}

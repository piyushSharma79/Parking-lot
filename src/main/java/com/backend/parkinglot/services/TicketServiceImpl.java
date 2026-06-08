package com.backend.parkinglot.services;

import com.backend.parkinglot.exceptions.NoSpotAvailableException;
import com.backend.parkinglot.models.*;
import com.backend.parkinglot.repositories.GateRepository;
import com.backend.parkinglot.repositories.ParkingLotRepository;
import com.backend.parkinglot.repositories.TicketRepository;
import com.backend.parkinglot.strategies.SpotAssignStrategy;

import java.util.Date;

public class TicketServiceImpl implements TicketService{
    private VehicleService vehicleService;
    private ParkingLotRepository parkingLotRepository;
    private SpotAssignStrategy spotAssignmentStrategy;
    private TicketRepository ticketRepository;
    private GateRepository gateRepository;

    public TicketServiceImpl(VehicleService vehicleService, ParkingLotRepository parkingLotRepository, SpotAssignStrategy spotAssignmentStrategy, TicketRepository ticketRepository, GateRepository gateRepository) {
        this.vehicleService = vehicleService;
        this.parkingLotRepository = parkingLotRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
    }

    @Override
    public Ticket generateTicket(String registration, int gateId, VehicleType vehicleType) throws NoSpotAvailableException {

        /*
        step#1: Create or get the vehicle
        step#2: Get the parkin lot obj via gateId
        step#3: Find the spot for parking. If nothing available, then throw an exception
        Else take the spot and assign it to the vehicle
        step#4: Create the ticket and return it
         */
        Vehicle vehicle = vehicleService.createOrGet(registration, vehicleType);
        ParkingLot parkingLot = parkingLotRepository.getByGateId(gateId);
        Spot spot = this.spotAssignmentStrategy.findAvailableSpot(parkingLot.getFloors(), vehicleType);
        spot.setVehicle(vehicle);
        Gate gate = this.gateRepository.getGateById(gateId);

        return ticketRepository.insertTicket(gate, new Date(), spot, vehicle);

    }
}

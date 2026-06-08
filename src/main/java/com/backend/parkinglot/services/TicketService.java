package com.backend.parkinglot.services;

import com.backend.parkinglot.exceptions.NoSpotAvailableException;
import com.backend.parkinglot.models.Ticket;
import com.backend.parkinglot.models.VehicleType;

public interface TicketService {
    Ticket generateTicket(String regNum, int gateId, VehicleType vehicleType) throws NoSpotAvailableException;
}

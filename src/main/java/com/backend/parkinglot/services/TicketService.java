package com.backend.parkinglot.services;

import com.backend.parkinglot.models.Ticket;
import com.backend.parkinglot.models.VehicleType;

public interface TicketService {
    public Ticket generateTicket(String regNum, int gateId, VehicleType vehicleType);
}

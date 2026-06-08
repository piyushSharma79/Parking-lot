package com.backend.parkinglot.repositories;

import com.backend.parkinglot.models.Gate;
import com.backend.parkinglot.models.Spot;
import com.backend.parkinglot.models.Ticket;
import com.backend.parkinglot.models.Vehicle;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Integer, Ticket> map;

    public TicketRepository(){
        map = new TreeMap<>();
    }

    public Ticket insertTicket(Gate gate, Date entryTime, Spot assignedSpot, Vehicle vehicle){
        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setAssignedSpot(assignedSpot);
        ticket.setEntryTime(entryTime);
        ticket.setVehicle(vehicle);
        ticket.setId(map.size() +1);

        map.put(ticket.getId(), ticket); //adding in DB
        return ticket;
    }
}

package com.backend.parkinglot.models;

import lombok.Data;

import java.util.Date;

@Data
public class Ticket {
    private int id;
    private Gate gate;
    private Date entryTime;
    private Vehicle vehicle;
    private Spot assignedSpot;
}

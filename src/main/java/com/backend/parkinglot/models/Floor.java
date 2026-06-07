package com.backend.parkinglot.models;

import lombok.Data;

import java.util.List;

@Data
public class Floor {
    private int id;
    int floorNum;
    private List<Spot> spots;
    private List<Gate> gates;
    private FloorStatus floorStatus;

}

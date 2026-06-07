package com.backend.parkinglot.models;

import lombok.Data;
import java.util.List;

@Data
public class ParkingLot {
    private int id;
    private List<Floor> floors;
    String address;
}

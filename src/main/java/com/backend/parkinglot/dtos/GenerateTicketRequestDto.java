package com.backend.parkinglot.dtos;

import com.backend.parkinglot.models.VehicleType;
import lombok.Data;

@Data
public class GenerateTicketRequestDto {
    private String regNum;
    private int gateId;
    private VehicleType vehicleType;
}

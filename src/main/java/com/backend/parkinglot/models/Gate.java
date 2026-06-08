package com.backend.parkinglot.models;

import lombok.Data;

@Data
public class Gate {
    private int id;
    private GateType gateType;
    private Operator currOperator;


}

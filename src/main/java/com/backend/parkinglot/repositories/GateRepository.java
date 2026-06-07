package com.backend.parkinglot.repositories;

import com.backend.parkinglot.models.Gate;

import java.util.Map;
import java.util.TreeMap;

public class GateRepository {
    private Map<Integer, Gate> map;

    public GateRepository() {
        this.map = new TreeMap<>();
    }
    public GateRepository(Map<Integer, Gate> map){
        this.map = map;
    }
}

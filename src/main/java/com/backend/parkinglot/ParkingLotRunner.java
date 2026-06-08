package com.backend.parkinglot;

import com.backend.parkinglot.controllers.TicketController;
import com.backend.parkinglot.dtos.GenerateTicketRequestDto;
import com.backend.parkinglot.dtos.GenerateTicketResponseDto;
import com.backend.parkinglot.exceptions.NoSpotAvailableException;
import com.backend.parkinglot.models.*;
import com.backend.parkinglot.repositories.*;
import com.backend.parkinglot.services.TicketService;
import com.backend.parkinglot.services.TicketServiceImpl;
import com.backend.parkinglot.services.VehicleService;
import com.backend.parkinglot.services.VehicleServiceImpl;
import com.backend.parkinglot.strategies.NearestAvailableStrategy;
import com.backend.parkinglot.strategies.SpotAssignStrategy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ParkingLotRunner {
    public static void main(String[] args) throws NoSpotAvailableException {


        Gate gate1 = new Gate();
        gate1.setId(1);
        gate1.setGateType(GateType.ENTRY);
        gate1.setCurrOperator(new Operator());

        Map<Integer, Gate> map = new TreeMap<>(){{
            put(1, gate1);
        }};

        GateRepository gateRepository = new GateRepository(map);
        Floor floor  = new Floor();
        floor.setGates(Arrays.asList(gate1));
        Spot spot1 = new Spot();
        spot1.setId(1);
        spot1.setType(VehicleType.CAR);

        Spot spot2 = new Spot();
        spot2.setId(2);
        spot2.setType(VehicleType.CAR);
        floor.setSpots(Arrays.asList(spot1, spot2));
        floor.setFloorStatus(FloorStatus.OPERATIONAL);
        floor.setId(1);

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress("Koramangla");
        parkingLot.setFloors(Arrays.asList(floor));
        parkingLot  .setId(1);

        Map<Integer, ParkingLot> parkingLotMap = new TreeMap<>(){{
            put(parkingLot.getId(), parkingLot);
        }};

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository(parkingLotMap);


        VehicleRepository vehicleRepository = new VehicleRepositoryImpl();
        VehicleService vehicleService = new VehicleServiceImpl();
        TicketRepository ticketRepository= new TicketRepository();
        SpotAssignStrategy strategy = new NearestAvailableStrategy();
        TicketService ticketService = new TicketServiceImpl(vehicleService, parkingLotRepository, strategy, ticketRepository, gateRepository);

        TicketController ticketController = new TicketController(ticketService);
        GenerateTicketRequestDto requestDto = new GenerateTicketRequestDto();
        requestDto.setVehicleType(VehicleType.BIKE);
        requestDto.setRegNum("UP16 AP3040");
        requestDto.setGateId(gate1.getId());

        GenerateTicketResponseDto responseDto = ticketController.generateTicket(requestDto);
        System.out.println("DEBUG");
    }
}

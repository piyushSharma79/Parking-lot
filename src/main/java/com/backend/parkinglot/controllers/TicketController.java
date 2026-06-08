package com.backend.parkinglot.controllers;

import com.backend.parkinglot.dtos.GenerateTicketRequestDto;
import com.backend.parkinglot.dtos.GenerateTicketResponseDto;
import com.backend.parkinglot.dtos.ResponseStatus;
import com.backend.parkinglot.exceptions.NoSpotAvailableException;
import com.backend.parkinglot.models.Ticket;
import com.backend.parkinglot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) throws NoSpotAvailableException{ //we directly not pass arguments in controller so make dtos
        //validations to be done on the DTO
        //if successful-> call the service

        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        try{
            Ticket ticket = ticketService.generateTicket(requestDto.getRegNum(), requestDto.getGateId(), requestDto.getVehicleType());
            responseDto.setStatus(ResponseStatus.SUCCESS);
            responseDto.setTicket(ticket);
        }
        catch (NoSpotAvailableException ex){
            responseDto.setStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}

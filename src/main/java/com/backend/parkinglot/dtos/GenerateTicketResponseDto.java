package com.backend.parkinglot.dtos;

import com.backend.parkinglot.models.Ticket;
import lombok.Data;

@Data
public class GenerateTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus status;
}

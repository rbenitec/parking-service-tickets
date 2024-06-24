package com.parking.service.tickets.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TicketDto {
    private Integer ticketNumber;
}

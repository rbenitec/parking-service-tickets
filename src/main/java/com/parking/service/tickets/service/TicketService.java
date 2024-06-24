package com.parking.service.tickets.service;

import com.parking.service.tickets.controller.dto.RequestDto;
import com.parking.service.tickets.controller.dto.TicketDto;
import com.parking.service.tickets.entity.TicketEntity;

import java.util.List;

public interface TicketService {
    TicketDto generatedTicket (RequestDto requestDto);
    List<TicketEntity> getAllList ();
    List<TicketEntity> getUserTickets (String username);
}

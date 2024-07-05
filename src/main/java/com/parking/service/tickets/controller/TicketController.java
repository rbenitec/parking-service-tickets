package com.parking.service.tickets.controller;

import com.parking.service.tickets.controller.dto.RequestDto;
import com.parking.service.tickets.controller.dto.TicketDto;
import com.parking.service.tickets.entity.TicketEntity;
import com.parking.service.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/created")
    public ResponseEntity<WrapperResponse<TicketDto>> generatedTicket(@RequestBody RequestDto request){
        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", ticketService.generatedTicket(request)).createResponse();
    }

    @GetMapping("/get-all")
    public ResponseEntity<WrapperResponse<List<TicketEntity>>> getAllTicket(){
        return new WrapperResponse<>(Boolean.TRUE, "MESSAGE", ticketService.getAllList()).createResponse();
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<WrapperResponse<List<TicketEntity>>> getAllTicket(@PathVariable("username") String username) {
        return new WrapperResponse<>(Boolean.TRUE, "MESSAGE", ticketService.getUserTickets(username)).createResponse();
    }
}

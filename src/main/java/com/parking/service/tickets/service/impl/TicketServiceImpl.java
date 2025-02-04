package com.parking.service.tickets.service.impl;

import com.parking.service.tickets.client.ParkingLotClient;
import com.parking.service.tickets.controller.dto.RequestDto;
import com.parking.service.tickets.controller.dto.TicketDto;
import com.parking.service.tickets.entity.AccountEntity;
import com.parking.service.tickets.entity.TicketEntity;
import com.parking.service.tickets.repository.TicketRepository;
import com.parking.service.tickets.service.AccountService;
import com.parking.service.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final ParkingLotClient parkingLotClient;

    private final AccountService accountService;

    @Override
    public TicketDto generatedTicket(RequestDto requestDto) {
        AccountEntity account = accountService.getAccountByUsername(requestDto.getUsername());
        TicketEntity ticketEntity = ticketRepository.save(buildTicketEntity(requestDto, account.getId()));
        // --> Actualizar el espacio
        parkingLotClient.updatePlace(requestDto.getPlaceId());
        //Build Response
        return TicketDto.builder()
                .ticketNumber(ticketEntity.getTicketNumber())
                .build();
    }
    @Override
    public List<TicketEntity> getAllList() {
        return ticketRepository.findAll();
    }
    @Override
    public List<TicketEntity> getUserTickets(String username) {
        return ticketRepository.getTicketsUser(username);
    }
    private TicketEntity buildTicketEntity(RequestDto requestDto, Integer accountId) {
        return TicketEntity.builder()
                .username(requestDto.getUsername())
                .placeId(requestDto.getPlaceId())
                .acoountId(accountId)
                .createdAt(LocalDateTime.now())
                .build();
    }
}

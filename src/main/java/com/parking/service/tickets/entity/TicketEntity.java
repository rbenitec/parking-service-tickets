package com.parking.service.tickets.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_number")
    private Integer ticketNumber;
    private String username;
    @Column(name = "vehicleid")
    private Integer vehicleId;
    @Column(name = "placeid")
    private Integer placeId;
    @Column(name = "createdat")
    private LocalDateTime createdAt;
    private String campus;
}

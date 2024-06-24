package com.parking.service.tickets.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_number")
    private Integer ticketNumber;
    private String username;
    @Column(name = "account_id")
    private Integer acoountId;
    @Column(name = "place_id")
    private Integer placeId;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

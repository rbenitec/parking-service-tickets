package com.parking.service.tickets.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    @Column(name = "nombres")
    private String names;
    @Column(name = "apellidos")
    private String lastnames;
    @Column(name = "estado")
    private Boolean status;
    private String dni;
    private String username;
    @Column(name = "qrcode")
    private String qrCode;
    @Column(name = "vehicle_id")
    private Integer vehicleId;

}

package com.parking.service.tickets.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Place {
    private Integer id;
    private String series;
    private String basement; //sotano
    private Integer status;
    private Integer available;
    private Integer parkingId;
}

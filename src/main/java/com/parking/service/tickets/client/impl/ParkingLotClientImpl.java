package com.parking.service.tickets.client.impl;

import com.parking.service.tickets.client.ParkingLotClient;
import com.parking.service.tickets.client.dto.Place;
import com.parking.service.tickets.client.dto.RequestParkingDto;
import com.parking.service.tickets.controller.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class ParkingLotClientImpl implements ParkingLotClient {
    private final RestTemplate restTemplate;

    @Value("${config.api.parking.lot.url}")
    private String urlPlace;

    @Override
    public Optional<Place> updatePlace(Integer idPlace) {
        RequestParkingDto requestDto = new RequestParkingDto(idPlace);
        try {
            Place responseEntity = restTemplate.exchange(
                    urlPlace,
                    HttpMethod.POST,
                    new HttpEntity<>(requestDto),
                    Place.class).getBody();
            assert responseEntity != null;
            return Optional.of(responseEntity);
        } catch (Exception e) {
            log.error("Error while getting la consulta al api parking: {}", e.getMessage());
        }
        return Optional.empty();
    }
}

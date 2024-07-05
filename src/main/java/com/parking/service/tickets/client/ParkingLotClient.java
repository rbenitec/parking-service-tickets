package com.parking.service.tickets.client;

import com.parking.service.tickets.client.dto.Place;

import java.util.Optional;

public interface ParkingLotClient {
    Optional<Place> updatePlace(Integer idPlace);
}

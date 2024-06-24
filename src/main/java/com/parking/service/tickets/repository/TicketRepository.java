package com.parking.service.tickets.repository;

import com.parking.service.tickets.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
    @Query(value = "SELECT * FROM TICKET t WHERE t.USERNAME=:username", nativeQuery = true)
    public List<TicketEntity> getTicketsUser (@Param("username") String username);
}

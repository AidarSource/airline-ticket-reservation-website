package org.example.airline.service;

import org.example.airline.entity.Ticket;

import java.util.Optional;

public interface TicketService {
    void save( Ticket ticket);
    Optional<Ticket> findById( Long id);
    void deleteById(Long id);
}

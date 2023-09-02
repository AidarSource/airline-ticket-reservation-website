package org.example.airline.service;

import org.example.airline.entity.Ticket;
import org.example.airline.repos.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl( TicketRepository ticketRepository ) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void save( Ticket ticket ) {
        ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> findById( Long id ) {
        return ticketRepository.findById( id );
    }

    @Override
    public void deleteById( Long id ) {
        ticketRepository.deleteById( id );
    }

}

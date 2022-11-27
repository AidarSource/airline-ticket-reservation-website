package org.example.airline.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;

    @OneToMany
    List<Flight> tickets;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User( String username, String password ) {
        this.username = username;
        this.password = password;
    }

    public void removeTicket( int id) {
        for( int i = 0; i < tickets.size(); i++ ) {
            if( tickets.get( i ).getId() == id ) {
                tickets.remove( i );
            }
        }
    }

    public void addToTickets(Flight flight) {
        tickets.add(flight);
    }

    public List<Flight> getTickets() {
        return tickets;
    }

    public void setTickets( List<Flight> tickets ) {
        this.tickets = tickets;
    }

    public boolean isAdmin() {
        return roles.contains( Role.ADMIN );
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive( boolean active ) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles( Set<Role> roles ) {
        this.roles = roles;
    }
}

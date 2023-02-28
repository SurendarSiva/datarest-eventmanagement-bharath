package io.suren.datarest.eventmanagementapi.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Participant extends AbstractEntity{

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private boolean checkedIn;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "ID", updatable = false, nullable = false)
    private Event event;

    public Long getResourceId(){
        return this.id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Participant) obj).id);
    }
}

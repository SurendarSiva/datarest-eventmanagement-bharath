package io.suren.datarest.eventmanagementapi.controllers;


import io.suren.datarest.eventmanagementapi.entities.Event;
import io.suren.datarest.eventmanagementapi.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController

public class EventKickOffController {

    @Autowired
    EventRepository eventRepository;

    @PostMapping("/events/start/{id}")
    public ResponseEntity start(@PathVariable long id){

        Event event = eventRepository.findById(id);
        if(event == null){
            throw new ResourceNotFoundException();
        }

        event.setStarted(true);
        eventRepository.save(event);

        return ResponseEntity.ok(event.getName() + " has started");
    }

}

package io.suren.datarest.eventmanagementapi.controllers;

import io.suren.datarest.eventmanagementapi.controllers.exceptions.AlreadyCheckedInException;
import io.suren.datarest.eventmanagementapi.entities.Participant;
import io.suren.datarest.eventmanagementapi.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RepositoryRestController
public class CheckInController {

    @Autowired
    ParticipantRepository participantRepository;

    @PostMapping("/events/checkin/{id}")
    public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler){

        Participant participant = participantRepository.findById(id);

        if(participant != null){
            if(participant.isCheckedIn()){
                throw new AlreadyCheckedInException();
            }
            participant.setCheckedIn(true);
            participantRepository.save(participant);
        }

        return ResponseEntity.ok(assembler.toFullResource(participant));
    }

}

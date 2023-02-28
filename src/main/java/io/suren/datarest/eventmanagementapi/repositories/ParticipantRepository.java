package io.suren.datarest.eventmanagementapi.repositories;

import io.suren.datarest.eventmanagementapi.entities.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {
}

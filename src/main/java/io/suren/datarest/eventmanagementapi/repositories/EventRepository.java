package io.suren.datarest.eventmanagementapi.repositories;

import io.suren.datarest.eventmanagementapi.entities.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
}

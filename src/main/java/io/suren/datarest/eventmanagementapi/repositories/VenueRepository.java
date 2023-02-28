package io.suren.datarest.eventmanagementapi.repositories;

import io.suren.datarest.eventmanagementapi.entities.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {
}

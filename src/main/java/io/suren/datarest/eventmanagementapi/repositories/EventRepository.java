package io.suren.datarest.eventmanagementapi.repositories;

import io.suren.datarest.eventmanagementapi.entities.Event;
import io.suren.datarest.eventmanagementapi.entities.projections.PartialEventProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.ZoneId;

@RepositoryRestResource(excerptProjection = PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {


    Event findById(long id);

    Page<Event> findByName(@Param("name") String name, Pageable pageable);
    //http://localhost:8080/eventmanagement-api/events/search/findByName?name=Spring Data Rest Training 1

    Page<Event> findByNameAndZoneId(@Param("name") String name,@Param("zoneId") ZoneId zoneId, Pageable pageable);

    Object save(Event event);
    //http://localhost:8080/eventmanagement-api/events/search/findByName?name=Spring Data Rest Training 1&zoneId=US/Central




    //Postman links
    //http://localhost:8080/eventmanagement-api/events/search/findByName?name=Spring Data Rest Training 1
    //http://localhost:8080/eventmanagement-api/events?page=1&size=5
    //http://localhost:8080/eventmanagement-api/events?sort=id,desc
    //http://localhost:8080/eventmanagement-api/events/search/findByName?name=Spring Data Rest Training 1&zoneId=US/Central

}

package io.suren.datarest.eventmanagementapi.entities.projections;

import io.suren.datarest.eventmanagementapi.entities.Event;
import org.springframework.data.rest.core.config.Projection;

import java.time.Instant;
import java.time.ZonedDateTime;

@Projection(name = "partial_event",types = {Event.class})
public interface PartialEventProjection {

    //http://localhost:8080/eventmanagement-api/events?projection=partial_event

    String getName();
    ZonedDateTime getStartTime();
    ZonedDateTime getEndTime();
    Instant getCreated();

}

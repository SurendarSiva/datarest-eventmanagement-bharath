package io.suren.datarest.eventmanagementapi.entities.projections;

import io.suren.datarest.eventmanagementapi.entities.Venue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "street_address",types = {Venue.class})
public interface StreetAddressProjection {

    @Value("#{target.streetAddress} #{target.streetAddress2}")
    String getCompleteAddress();

    //http://localhost:8080/eventmanagement-api/venues?projection=street_address

}

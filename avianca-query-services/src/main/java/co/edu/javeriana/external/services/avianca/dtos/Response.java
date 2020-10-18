package co.edu.javeriana.external.services.avianca.dtos;
import co.edu.javeriana.external.services.avianca.domain.AvalaibleFlight;
import co.edu.javeriana.external.services.avianca.dtos.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private Status status;
    private List<AvalaibleFlight> departureFlights;
    private List<AvalaibleFlight> returnFlights;
}

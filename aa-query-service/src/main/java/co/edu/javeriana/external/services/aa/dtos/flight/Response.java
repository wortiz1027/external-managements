package co.edu.javeriana.external.services.aa.dtos.flight;

import co.edu.javeriana.external.services.aa.domain.Flight;
import co.edu.javeriana.external.services.aa.dtos.Status;
import lombok.Data;

@Data
public class Response implements java.io.Serializable {

    private Status status;
    private Flight flight;

}

package co.edu.javeriana.external.services.bl.dtos;

import co.edu.javeriana.external.services.bl.domain.Passenger;
import co.edu.javeriana.external.services.bl.domain.Status;
import lombok.Data;

import java.util.List;

@Data
public class Response implements java.io.Serializable {

    private Status status;
    private List<Passenger> passengers;

}

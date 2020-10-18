package co.edu.javeriana.external.services.aa.dtos.all;

import co.edu.javeriana.external.services.aa.domain.Flight;
import co.edu.javeriana.external.services.aa.dtos.Status;
import lombok.Data;

import java.util.List;

@Data
public class Response implements java.io.Serializable {

    private Status status;
    private List<Flight> flights;

}

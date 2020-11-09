package co.edu.javeriana.external.services.dc.dtos.code;

import co.edu.javeriana.external.services.dc.domain.Reserva;
import co.edu.javeriana.external.services.dc.domain.Status;
import lombok.Data;

@Data
public class Response implements java.io.Serializable {

    private Status status;
    private Reserva reserva;

}

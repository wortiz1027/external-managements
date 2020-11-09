package co.edu.javeriana.external.services.dc.dtos.all;

import co.edu.javeriana.external.services.dc.domain.Reserva;
import co.edu.javeriana.external.services.dc.domain.Status;
import lombok.Data;

import java.util.List;

@Data
public class Response implements java.io.Serializable {

    private Status status;
    private List<Reserva> reservas;

}

package co.edu.javeriana.external.services.bl.domain;

import lombok.Data;

@Data
public class Passenger implements java.io.Serializable {

    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numeroDocumento;
    private String fecha;
    private String hora;
    private String origen;
    private String destino;

}

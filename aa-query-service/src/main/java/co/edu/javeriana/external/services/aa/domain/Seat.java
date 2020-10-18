package co.edu.javeriana.external.services.aa.domain;

import lombok.Data;

@Data
public class Seat implements java.io.Serializable {
    private String number;
    private String available;
}

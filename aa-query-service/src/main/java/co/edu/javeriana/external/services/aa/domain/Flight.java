package co.edu.javeriana.external.services.aa.domain;

import lombok.Data;

import java.util.List;

@Data
public class Flight implements java.io.Serializable {

    private String number;
    private String source;
    private String destination;
    private String date;
    private List<Seat> seats;

}

package co.edu.javeriana.external.services.avianca.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {

    private Date departureDate;
    private String destinationCityDescription;
    private Boolean oneWay;
    private String originCityDescription;
    private Integer passengersNumber;
    private Date returnDate;

}

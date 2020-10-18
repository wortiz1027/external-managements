package co.edu.javeriana.external.services.avianca.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvalaibleFlight {

    @JsonProperty("airLine")
    protected String airLine;
    @JsonProperty("amount")
    protected Double amount;
    @JsonProperty("cityFrom")
    protected String cityFrom;
    @JsonProperty("cityTo")
    protected String cityTo;
    @JsonProperty("destinationAirportCode")
    protected Integer destinationAirportCode;
    @JsonProperty("destinationAirportName")
    protected String destinationAirportName;
    @JsonProperty("durationString")
    protected String durationString;
    @JsonProperty("flightEnd")
    protected Date flightEnd;
    @JsonProperty("flightNumber")
    protected String flightNumber;
    @JsonProperty("flightScale")
    protected String flightScale;
    @JsonProperty("flightScaleNumber")
    protected Integer flightScaleNumber;
    @JsonProperty("flightStart")
    protected Date flightStart;
    @JsonProperty("id")
    protected Integer id;
    @JsonProperty("originAirportCode")
    protected Integer originAirportCode;
    @JsonProperty("originAirportName")
    protected String originAirportName;
    @JsonProperty("passengersNumber")
    protected Integer passengersNumber;
    @JsonProperty("totalDurationInMinutes")
    protected Double totalDurationInMinutes;

}

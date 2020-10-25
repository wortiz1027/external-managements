package co.edu.javeriana.external.services.ht.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class Response implements Serializable {
     private final Date date;
     private final String request;
     private final boolean response;
}

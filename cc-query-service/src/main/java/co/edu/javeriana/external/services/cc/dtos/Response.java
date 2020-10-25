package co.edu.javeriana.external.services.cc.dtos;

import co.edu.javeriana.external.services.cc.domain.CreditCard;
import lombok.Data;

@Data
public class Response implements java.io.Serializable {

    private Status status;
    private CreditCard creditCard;

}

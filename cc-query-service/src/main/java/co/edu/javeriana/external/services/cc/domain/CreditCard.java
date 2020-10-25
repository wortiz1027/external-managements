package co.edu.javeriana.external.services.cc.domain;

import lombok.Data;

@Data
public class CreditCard implements java.io.Serializable{
    
    private String emisorTarjeta;
    private String numero;
    private double balance;

}

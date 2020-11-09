package co.edu.javeriana.external.services.dc.domain;

import lombok.Data;

@Data
public class Status implements java.io.Serializable {

    protected String code;
    protected String description;

}
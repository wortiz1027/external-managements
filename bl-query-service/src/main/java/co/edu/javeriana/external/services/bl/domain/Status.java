package co.edu.javeriana.external.services.bl.domain;

import lombok.Data;

@Data
public class Status implements java.io.Serializable {

    protected String code;
    protected String description;

}
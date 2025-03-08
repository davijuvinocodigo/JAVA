package br.com.pehenmo.camel.redis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address implements Serializable {
    private static final long serialVersionUID = -1049918186280043485L;

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}

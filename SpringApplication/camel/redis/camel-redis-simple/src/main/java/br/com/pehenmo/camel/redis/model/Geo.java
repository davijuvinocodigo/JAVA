package br.com.pehenmo.camel.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Geo implements Serializable {
    private static final long serialVersionUID = -1049918186280043485L;
    private String lat;
    private String lng;
}

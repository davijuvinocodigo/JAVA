package br.com.pehenmo.camel.redis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company implements Serializable {
    private static final long serialVersionUID = -1049918186280043485L;

    private String name;
    private String catchPhrase;
    private String bs;
}

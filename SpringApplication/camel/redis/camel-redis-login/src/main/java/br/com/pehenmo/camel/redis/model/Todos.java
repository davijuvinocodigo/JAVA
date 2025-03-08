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
public class Todos implements Serializable {

    private static final long serialVersionUID = -1049918186280043485L;

    private Integer userId;
    private Integer id;
    private String title;
    private boolean completed;

}

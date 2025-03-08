package com.hellokoding.jpa.bidirectional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


/* json required
 * 

{"name": "hellocoding",
"books" : [
	{
		"name": "springboot in practise"
	},
	{
		"name": "java tutorials"
	}
 ]
	
}

CREATE TABLE library
( id numeric(10) not null,
  name varchar2(50),
  CONSTRAINT library_pk PRIMARY KEY (id)
);

CREATE TABLE book
( id numeric(10) not null,
  name varchar2(50) not null,
  library_id numeric(10),
  CONSTRAINT fk_library
    FOREIGN KEY (library_id)
    REFERENCES library(id)
);


*/
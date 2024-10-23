package com.FlorDaCidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableOpenApi // Habilita o Swagger
public class FlorDaCidadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlorDaCidadeApplication.class, args);
    }
}

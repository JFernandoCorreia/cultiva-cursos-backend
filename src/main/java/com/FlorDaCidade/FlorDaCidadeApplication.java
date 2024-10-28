package com.FlorDaCidade;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableOpenApi // Habilita o Swagger
public class FlorDaCidadeApplication {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Carrega as variáveis do arquivo .env
        Dotenv dotenv = Dotenv.load();

        // Imprime a URL do banco de dados para verificação
        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER");
        String dbPass = dotenv.get("DB_PASS");
        
        // Imprime a URL do banco de dados para verificação
        System.out.println("DB_URL: " + dotenv.get("DB_URL"));
        System.out.println("DB_USER: " + dotenv.get("DB_USER"));
        System.out.println("DB_PASS: " + dotenv.get("DB_PASS"));

        // Inicializa o aplicativo Spring Boot
        SpringApplication.run(FlorDaCidadeApplication.class, args);
    }
}

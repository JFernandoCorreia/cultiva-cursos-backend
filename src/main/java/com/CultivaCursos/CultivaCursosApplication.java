package com.CultivaCursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class CultivaCursosApplication {

    public static void main(String[] args) {
        // Carregar variáveis de ambiente do arquivo .env
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        String dbUrl = dotenv.get("DB_URL", "NÃO DEFINIDO");
        String dbUser = dotenv.get("DB_USER", "NÃO DEFINIDO");
        String dbPass = dotenv.get("DB_PASS", "********"); // Oculta a senha por segurança

        System.out.println("🚀 Iniciando CultivaCursos...");
        System.out.println("📌 DB_URL: " + dbUrl);
        System.out.println("👤 DB_USER: " + dbUser);
        System.out.println("🔒 DB_PASS: " + dbPass);

        SpringApplication.run(CultivaCursosApplication.class, args);
    }
}

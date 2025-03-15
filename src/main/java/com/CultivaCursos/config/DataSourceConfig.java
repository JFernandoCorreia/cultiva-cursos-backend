package com.CultivaCursos.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPass;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPass);
        config.setDriverClassName(driverClassName);

        // Configurações para otimização do pool de conexões
        config.setMaximumPoolSize(20); // Define um número adequado de conexões
        config.setMinimumIdle(5); // Conexões mínimas ociosas
        config.setIdleTimeout(30000); // Tempo limite de inatividade (30s)
        config.setMaxLifetime(1800000); // Tempo máximo de vida de uma conexão (30min)
        config.setConnectionTimeout(30000); // Tempo para adquirir uma conexão (30s)
        
        return new HikariDataSource(config);
    }
}

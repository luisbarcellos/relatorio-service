package br.com.relatorio.dataanalise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataAnaliseModule {
    @Bean
    DataAnalise dataAnalise() {
        return new DataAnalise();
    }
}
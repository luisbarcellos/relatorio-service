package br.com.relatorio.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceModule {

    @Bean
    public ClienteService clienteService() {
        return new ClienteService();
    }

    @Bean
    public VendaService vendaService() {
        return new VendaService();
    }

    @Bean
    public VendedorService vendedorService() {
        return new VendedorService();
    }
}
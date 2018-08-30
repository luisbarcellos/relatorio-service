package br.com.relatorio.listeners;

import java.util.List;

@FunctionalInterface
public interface ArquivoOuvinte {
    void processar(List<String> linhas);
}
package br.com.relatorio.listeners;

import br.com.relatorio.data.ClienteData;
import br.com.relatorio.parser.DefaultParser;

import java.util.List;

public class ClienteArquivoOuvinte implements ArquivoOuvinte {
    private static final String CLIENTE_ID = "001";

    private ClienteData clienteData;

    public ClienteArquivoOuvinte(){
        this.clienteData = ClienteData.getInstance();
    }

    @Override
    public void processar(List<String> linhas) {
        this.clienteData.add(DefaultParser.parseDefaultIdentificador(linhas, CLIENTE_ID));
    }
}
package br.com.relatorio.listeners;

import br.com.relatorio.data.VendedorData;
import br.com.relatorio.parser.DefaultParser;

import java.util.List;

public class VendedorArquivoOuvinte implements ArquivoOuvinte {

    private VendedorData vendedorData = VendedorData.getInstance();
    private static final String VENDEDOR_ID = "002";

    @Override
    public void processar(List<String> linhas) {
        vendedorData.add(DefaultParser.parseDefaultIdentificador(linhas, VENDEDOR_ID));
    }
}

package br.com.relatorio.listeners;

import br.com.relatorio.data.VendaData;
import br.com.relatorio.parser.VendaTextParser;

import java.util.List;

public class VendaArquivoOuvinte implements ArquivoOuvinte{

    private VendaData vendaData;

    public VendaArquivoOuvinte() {
        this.vendaData = VendaData.getInstance();
    }

    @Override
    public void processar(List<String> lines) {
        this.vendaData.add(VendaTextParser.parseSale(lines));
    }
}
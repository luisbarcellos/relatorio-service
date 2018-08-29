package br.com.relatorio.parser;

import br.com.relatorio.model.ItemModel;
import br.com.relatorio.model.VendaModel;

import java.util.List;
import java.util.stream.Collectors;

public class VendaTextParser {
    private static final String SALE_ID = "003";

    public static List<VendaModel> parseSale(List<String> fileText) {
        return DefaultParser.parse(fileText)
                .stream().filter(i -> i.get(0).equals(SALE_ID))
                .map(i -> venda(i, parseItem(i.get(2))))
                .collect(Collectors.toList());
    }

    private static List<ItemModel> parseItem(String item){
        List<String> itens = ItemTextParser.parse(item);
        List<List<String>> test = itens.stream().map(ItemTextParser::parseItens).collect(Collectors.toList());

        return test.stream()
                .map(ItemTextParser::itemParse)
                .collect(Collectors.toList());
    }

    private static VendaModel venda(List<String> venda, List<ItemModel> item){
        return VendaModel.builder()
                .id(venda.get(0))
                .numeroVenda(venda.get(1))
                .itens(item)
                .valorVenda(somarValorVenda(item))
                .nomeVendedor(venda.get(3))
                .build();
    }

    private static Double somarValorVenda(List<ItemModel> itensVenda){
        return itensVenda.stream().mapToDouble(ItemModel::getAgrupaValorItem).sum();
    }
}
package br.com.relatorio.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultParser {
    private static final String SEPARADOR = "ç";

    public static List<List<String>> parse(List<String> lines){
        return lines.stream()
                .map(l -> new ArrayList<>(Arrays.asList(l.split(SEPARADOR))))
                .collect(Collectors.toList());
    }

    public static List<String> parseDefaultIdentificador(List<String> lines, String id){
        return parse(lines).stream()
                .filter(li -> li.get(0).equals(id))
                .map(l -> l.get(1))
                .collect(Collectors.toList());
    }
}
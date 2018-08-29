package br.com.relatorio.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class LeitorArquivo {
    public List<String> ler(List<File> files) {
        List<String> lines = files.stream().map(f -> {
            try {
                return Files.readAllLines(f.toPath());
            } catch (IOException e) {
                System.out.println("Erro ao ler arquivo: " + e.getMessage());
                return null;
            }
        }).flatMap(l -> l.stream()).collect(Collectors.toList());
        return lines;
    }
}
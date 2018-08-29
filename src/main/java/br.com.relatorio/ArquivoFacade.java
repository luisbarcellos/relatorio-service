package br.com.relatorio;

import br.com.relatorio.file.LeitorArquivo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ArquivoFacade {
    //    private static Path diretorioPath = Paths.get("%HOMEPATH%/data/in");
    private static Path diretorioPath = Paths.get("./data");
    private LeitorArquivo leitorArquivo = new LeitorArquivo();

    public void processarInformacoesArquivos(){
    }
}
package br.com.relatorio;

import br.com.relatorio.dataanalise.DataAnalise;
import br.com.relatorio.file.ArquivoObservador;
import br.com.relatorio.file.LeitorArquivo;
import br.com.relatorio.listeners.ArquivoOuvinte;
import br.com.relatorio.listeners.ClienteArquivoOuvinte;
import br.com.relatorio.listeners.VendaArquivoOuvinte;
import br.com.relatorio.listeners.VendedorArquivoOuvinte;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ArquivoFacade {
    private static Path diretorioPath = Paths.get("%HOMEPATH%/data/in");
    private ArquivoObservador arquivoObservador = new ArquivoObservador();
    private LeitorArquivo leitorArquivo = new LeitorArquivo();
    private DataAnalise dataAnalise = new DataAnalise();
    private Set<ArquivoOuvinte> ouvintes =
        new HashSet<>(Arrays.asList(new ClienteArquivoOuvinte(), new VendedorArquivoOuvinte(), new VendaArquivoOuvinte()));

    public void processarInformacoesArquivos(){
        registrarArquivoOuvinte();
        lerArquivosExistentes();

        try {
            arquivoObservador.verArquivos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registrarArquivoOuvinte(){
        arquivoObservador.registrarOuvintes(ouvintes);
    }

    private void lerArquivosExistentes() {
        Optional.ofNullable(leitorArquivo.ler(Arrays.asList(new File(diretorioPath.getFileName().toString()).listFiles())))
            .filter(l-> l.size() > 0)
            .ifPresent(l-> {
                System.out.println("notificou");
                arquivoObservador.notificarOuvintes(l);
                dataAnalise.formularioModel();
            });
    }
}
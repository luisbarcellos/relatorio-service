package br.com.relatorio.file;

import br.com.relatorio.dataanalise.DataAnalise;
import br.com.relatorio.listeners.ArquivoOuvinte;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class ArquivoObservador {

    private Path diretorioPath = Paths.get("%HOMEPATH%/data/in");
    private LeitorArquivo leitorArquivo = new LeitorArquivo();
    private Set<ArquivoOuvinte> ouvintes = new HashSet<>();
    private DataAnalise dataAnalise = new DataAnalise();

    public void verArquivos() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        diretorioPath.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE
        );

        WatchKey watchKey;
        while ((watchKey = watchService.take()) != null) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                if(!event.context().toString().contains("___jb_tmp___") && !event.context().toString().contains("___jb_old___")) {
                    notificarOuvintes(lerArquivo(event.context().toString()));
                    dataAnalise.formularioModel();
                }
            }
            watchKey.reset();
        }
    }

    public List<String> lerArquivo(String nomeArquivo){
        return leitorArquivo.ler(Arrays.asList(new File(diretorioPath + "/" + nomeArquivo)));
    }

    public void notificarOuvintes(List<String> lines){
        ouvintes.parallelStream()
                .forEach(ls -> ls.processar(lines));
    }

    public void registrarOuvintes(Set<? extends ArquivoOuvinte> ouvintes){
        this.ouvintes.addAll(ouvintes);
    }
}
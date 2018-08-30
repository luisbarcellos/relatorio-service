package br.com.relatorio.dataanalise;

import br.com.relatorio.model.FormularioModel;
import br.com.relatorio.service.ClienteService;
import br.com.relatorio.service.VendaService;
import br.com.relatorio.service.VendedorService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataAnalise {
    private ClienteService clienteService = new ClienteService();
    private VendedorService vendedorService = new VendedorService();
    private VendaService vendaService = new VendaService();

    private Path path = Paths.get("%HOMEPATH%/data/out/output.done.dat");

    public void formularioModel() {
        FormularioModel build = FormularioModel.builder()
                .quantidadeCliente(clienteService.getTotalCliente())
                .quantidadeVendedor(vendedorService.getTotalVendedor())
                .idVendaMaisCara(vendaService.getMelhorVenda())
                .piorVendedor(vendaService.piorVenda())
                .build();

        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            writer.write(build.toString());
            System.out.println("Salvou!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
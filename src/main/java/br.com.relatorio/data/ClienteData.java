package br.com.relatorio.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClienteData {
    private Set<String> clienteCnpj;
    private static ClienteData clienteData = new ClienteData();

    private ClienteData(){
        clienteCnpj = new HashSet<>();
    }

    public void add(List<String> clienteCnpj){
        this.clienteCnpj.addAll(clienteCnpj);
    }

    public Set<String> getClienteCnpj(){
        return this.clienteCnpj;
    }

    public static ClienteData getInstance(){
        return clienteData;
    }
}
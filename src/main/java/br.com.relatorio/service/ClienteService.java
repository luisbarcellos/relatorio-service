package br.com.relatorio.service;

import br.com.relatorio.data.ClienteData;

public class ClienteService {
    private ClienteData clienteData;

    public ClienteService(){
        this.clienteData = ClienteData.getInstance();
    }

    public Long getTotalCliente() {
        return clienteData.getClienteCnpj().stream().distinct().count();
    }
}

package br.com.relatorio.service;

import br.com.relatorio.data.VendedorData;

public class VendedorService {
    private VendedorData vendedorData = VendedorData.getInstance();

    public Long getTotalVendedor() {
        return vendedorData.getVendedorCpf().stream().distinct().count();
    }
}
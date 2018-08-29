package br.com.relatorio.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VendedorData {
    private Set<String> vendedorCpf;
    private static VendedorData vendedorData = new VendedorData();

    private VendedorData(){
        vendedorCpf = new HashSet<>();
    }

    public void add(List<String> vendedorCpf){
        this.vendedorCpf.addAll(vendedorCpf);
    }

    public Set<String> getVendedorCpf(){
        return this.vendedorCpf;
    }

    public static VendedorData getInstance(){
        return vendedorData;
    }
}
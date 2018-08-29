package br.com.relatorio.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VendaData {
    private Set<VendaData> vendaModel;
    private static VendaData vendaData = new VendaData();

    public VendaData() {
        vendaModel = new HashSet<>();
    }
    public void add(List<VendaData> vendaModel) {
        this.vendaModel.addAll(vendaModel);
    }

    public Set<VendaData> getVendaModel() {
        return this.vendaModel;
    }

    public static VendaData getInstance() {
        return vendaData;
    }
}
package br.com.relatorio.data;

import br.com.relatorio.model.VendaModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VendaData {
    private Set<VendaModel> vendaModel;
    private static VendaData vendaData = new VendaData();

    public VendaData() {
        vendaModel = new HashSet<>();
    }
    public void add(List<VendaModel> vendaModel) {
        this.vendaModel.addAll(vendaModel);
    }

    public Set<VendaModel> getVendaModel() {
        return this.vendaModel;
    }

    public static VendaData getInstance() {
        return vendaData;
    }
}
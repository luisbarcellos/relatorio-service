package br.com.relatorio.service;

import br.com.relatorio.data.VendaData;
import br.com.relatorio.model.VendaModel;
import br.com.relatorio.model.VendedorValor;
import org.springframework.util.ObjectUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VendaService {

    private VendaData vendaData;

    public VendaService() {
        this.vendaData = VendaData.getInstance();
    }

    public List<String> piorVenda(){
      List<VendaModel> getVendaList = vendaData.getVendaModel().stream().distinct().collect(Collectors.toList());

      List<String> vendedor = getVendaList.stream().map(i -> i.getNomeVendedor()).distinct().collect(Collectors.toList());
      vendedor.stream()
              .map(sl -> getVendaList.stream().filter(t -> t.getNomeVendedor().equals(sl)).collect(Collectors.toList()));

      List<VendedorValor> vendedorValorList = vendedor.stream().map(sl -> {
      List<VendaModel> vendaModelList =
          getVendaList.stream().filter(t -> t.getNomeVendedor().equals(sl)).collect(Collectors.toList());

        return VendedorValor.builder()
            .vendedor(sl)
            .valor(vendaModelList.stream().mapToDouble(VendaModel::getValorVenda).sum())
            .build();
      }).collect(Collectors.toList());

      return vendedorValorList.stream()
              .filter(s -> s.getValor().equals(vendedorValorList.stream()
              .map(VendedorValor::getValor).min(Double::compare).get())).collect(Collectors.toList())
              .stream()
              .map(VendedorValor::getVendedor).collect(Collectors.toList());
    }

    public String getMelhorVenda() {
        return vendaData.getVendaModel().stream()
                .max(Comparator.comparing(VendaModel::getValorVenda))
                .get().getNumeroVenda();
    }
}

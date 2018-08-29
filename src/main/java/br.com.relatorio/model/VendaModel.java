package br.com.relatorio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendaModel {
    private String id;
    private String numeroVenda;
    private String nomeVendedor;
    private List<ItemModel> itens;
    private Double valorVenda;
}

package br.com.relatorio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemModel {
    private String idItem;
    private String quantidade;
    private String preco;
    private Double agrupaValorItem;
}

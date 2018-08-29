package br.com.relatorio.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormularioModel {
    private Long quantidadeCliente;
    private Long quantidadeVendedor;
    private String idVendaMaisCara;
    protected List<String> piorVendedor;
}

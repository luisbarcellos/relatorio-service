package br.com.relatorio.stub;

import br.com.relatorio.model.VendaModel;

import java.util.Arrays;
import java.util.List;

public class VendaStub {
    public static List<String> vendaTextTest() {
        String sale1 = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego";

        return Arrays.asList(sale1);
    }

    public static List<VendaModel> getVendaModel(){
       return Arrays.asList(VendaModel.builder()
                .nomeVendedor("Diego")
                .valorVenda(1199.0)
                .numeroVenda("10")
                .id("003")
                .itens(ItemModelStub.getItemModel())
                .build());
    }
}

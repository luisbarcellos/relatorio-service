package br.com.relatorio.stub;

import br.com.relatorio.model.ItemModel;

import java.util.Arrays;
import java.util.List;

public class ItemModelStub {
    public static List<ItemModel> getItemModel(){
        return Arrays.asList(getItem1(), getItem2(), getItem3());
    }

    public static String getItemText(){
        return "[1-10-100,2-30-2.50,3-40-3.10]";
    }

    public static List<String> getItens() {
        return Arrays.asList("1-10-100", "2-30-2.50", "3-40-3.10");
    }

    private static ItemModel getItem1(){
        return ItemModel.builder()
                .agrupaValorItem(1000.0)
                .idItem("1")
                .quantidade("10")
                .preco("100")
                .build();
    }

    private static ItemModel getItem2(){
        return ItemModel.builder()
                .agrupaValorItem(75.0)
                .idItem("2")
                .quantidade("30")
                .preco("2.50")
                .build();
    }

    private static ItemModel getItem3(){
        return ItemModel.builder()
                .agrupaValorItem(124.0)
                .idItem("3")
                .quantidade("40")
                .preco("3.10")
                .build();
    }
}
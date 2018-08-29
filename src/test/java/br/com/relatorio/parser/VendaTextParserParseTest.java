package br.com.relatorio.parser;

import br.com.relatorio.stub.VendaStub;
import org.junit.Assert;
import org.junit.Test;

public class VendaTextParserParseTest {
    @Test
    public void shouldReturnSaleModel() {
        Assert.assertEquals(VendaTextParser.parseSale(VendaStub.vendaTextTest()), VendaStub.getVendaModel());
    }
}
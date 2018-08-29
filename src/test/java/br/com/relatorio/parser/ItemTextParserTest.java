package br.com.relatorio.parser;

import br.com.relatorio.stub.ItemModelStub;
import org.junit.Assert;
import org.junit.Test;

public class ItemTextParserTest {
    @Test
    public void shouldReturnListStringItens() {
        Assert.assertEquals(ItemTextParser.parse(ItemModelStub.getItemText()), ItemModelStub.getItens());
    }
}
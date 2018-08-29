import br.com.relatorio.ArquivoFacade;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class Main {
    private static ArquivoFacade arquivoFacade = new ArquivoFacade();

    public static void main(String... args) {
        arquivoFacade.processarInformacoesArquivos();
    }
}
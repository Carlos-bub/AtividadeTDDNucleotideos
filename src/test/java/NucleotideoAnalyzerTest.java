/**
 * Classe responsável pelos testes.
 * @author carloshenriquenascimento
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class NucleotideoAnalyzerTest {

    @Test
    @DisplayName("Verifica se o método retorna a contagem correta de nucleotídeos")
    void testSequenciaValida() throws IOException {
        NucleotideoAnalyzer analyzer = new NucleotideoAnalyzer();
        int[] resultado = analyzer.calculaNucleotideos("src/test/resources/sequencia_valida.txt");
        assertArrayEquals(new int[]{4, 2, 2, 2, 0}, resultado);
    }

    @Test
    @DisplayName("Verifica se o método retorna corretamente com um erro de caractere inválido")
    void testSequenciaComErro() throws IOException {
        NucleotideoAnalyzer analyzer = new NucleotideoAnalyzer();
        int[] resultado = analyzer.calculaNucleotideos("src/test/resources/sequencia_com_erro.txt");
        assertArrayEquals(new int[]{3, 2, 2, 2, 1}, resultado);
    }

    @Test
    @DisplayName("Verifica se o método retorna null quando a sequência tem mais de 10% de erros")
    void testSequenciaInvalida() throws IOException {
        NucleotideoAnalyzer analyzer = new NucleotideoAnalyzer();
        assertNull(analyzer.calculaNucleotideos("src/test/resources/sequencia_invalida.txt"));
    }

    @Test
    @DisplayName("Verifica se o método lança exceção ao não encontrar o arquivo")
    void testArquivoNaoEncontrado() {
        NucleotideoAnalyzer analyzer = new NucleotideoAnalyzer();
        assertThrows(IOException.class, () -> {
            analyzer.calculaNucleotideos("src/test/resources/arquivo_inexistente.txt");
        });
    }
}

package Checked;

import java.io.File;
import java.io.IOException;

/**
 * Trabalhando com Assinaturas
 */

public class Checked {
    public static void main(String[] args) throws IOException {
        criarNovoArquivo();
    }

    /**
     * Checked exceptions são utilizadas para erros recuperáveis enquanto que
     *     Unchecked exceptions são utilizadas para erros irrecuperáveis.
     *     Significa dizer que quando você sabe que seu erro pode ser tratado, você utiliza Checked Exceptions,
     *     caso contrário utilize Unchecked Exceptions.
     * @throws IOException
     */
    public static void criarNovoArquivo() throws IOException {
        File file = new File("arquivo\\teste.txt");
        try {
            boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado");
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }
}
package Exception;

import java.io.File;
import java.io.IOException;

/**
 * Exception do tipo checked que precisamos realizar um tratamento
 */
public class Exception {
    public static void main(String[] args) {
        criarNovoArquivo();
    }

    public static void criarNovoArquivo(){
        File file = new File("arquivo\\teste.txt");
        try {
           boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

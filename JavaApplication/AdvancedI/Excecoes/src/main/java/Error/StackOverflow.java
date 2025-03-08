package Error;

/**
 *    Error que não conseguimos recuperar em tempo de execução
 *     Neste caso devemos realizar o tratamento.
 */
public class StackOverflow {
    public static void main(String[] args) {

        recursividade();
    }

    public static void recursividade(){
        recursividade();
    }
}

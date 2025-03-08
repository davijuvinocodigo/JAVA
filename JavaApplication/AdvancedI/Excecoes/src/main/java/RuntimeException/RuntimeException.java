package RuntimeException;

/**
 * (Exception) - RuntimeException uma execeção do tipo Uncheck
 *     Neste caso você não precisa obrigatóriamente realizar o tratamento no codigo para compilar.
 */
public class RuntimeException {
    public static void main(String[] args) {

        Object o = null;
        // Aqui eu forço um erro não tratado de objeto nulo.
        System.out.println(o.toString());
    }
}

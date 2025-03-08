package Unchecked;

public class Unchecked {
    public static void main(String[] args) {
        divisao(1,0);
    }

    /**
     * Checked exceptions são utilizadas para erros recuperáveis enquanto que
     *     Unchecked exceptions são utilizadas para erros irrecuperáveis.
     *     Significa dizer que quando você sabe que seu erro pode ser tratado, você utiliza Checked Exceptions,
     *     caso contrário utilize Unchecked Exceptions.
     * @param a
     * @param b
     * @return
     */
    private static int divisao(int a, int b){
        if (b == 0){
            throw new IllegalArgumentException("Argumento invalido!");
        }
        return a/b;
    }
}

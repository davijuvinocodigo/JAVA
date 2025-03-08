package TokensDelimitadores;

public class TokensDelimitadores_ {
    public static void main(String[] args) {
        String texto = "Levi9Eren1Mikasa";
        String[] nomes = texto.split("\\d");
        for ( String nome : nomes) {
            System.out.println(nome.trim());
        }
    }
}

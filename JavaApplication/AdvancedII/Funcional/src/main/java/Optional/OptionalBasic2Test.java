package Optional;

/**
 * https://stackabuse.com/guide-to-optional-in-java-8/
 * */

import Optional.model.Spaceship;

import java.util.Optional;

/**
 * Ao escrever qualquer tipo de código em Java, os desenvolvedores tendem a trabalhar com objetos
 * com mais frequência do que com valores primitivos ( int, boolean, etc). Isso ocorre porque os
 * objetos estão na própria essência da programação orientada a objetos: eles permitem que um
 * programador escreva código abstrato de maneira limpa e estruturada.
 *
 * Além disso, todo objeto em Java pode conter um valor ou não. Em caso afirmativo, seu valor é
 * armazenado no heap e a variável que estamos usando tem uma referência a esse objeto. Se o objeto
 * não contém nenhum valor, o padrão é null- um marcador de posição especial que indica a ausência de
 * um valor.
 *
 * O fato de que cada objeto pode se tornar null, combinado com a tendência natural de usar objetos
 * em vez de primitivos, significa que algum trecho arbitrário de código pode (e frequentemente resultará)
 * em um inesperado NullPointerException.
 *
 * Antes da Optionalclasse ser introduzida no Java 8, esse tipo de NullPointerExceptionerro era muito
 * mais comum no dia a dia de um programador Java.
 *
 * Nas seções a seguir, vamos nos aprofundar na explicação Optionale ver como ele pode ser usado para
 * superar alguns dos problemas comuns relacionados a valores nulos.
 *
 * A Classe Opcional
 *
 * Um opcional é essencialmente um contêiner. Ele é projetado para armazenar um valor ou para ficar
 * "vazio" se o valor for inexistente - uma substituição para o nullvalor. Como veremos em alguns exemplos
 * posteriores, essa substituição é crucial, pois permite a verificação implícita de nulo para cada objeto
 * representado como um arquivo Optional.
 *
 * Isso significa que a verificação nula explícita não é mais necessária do ponto de vista do programador
 * - ela é imposta pela própria linguagem.
 *
 * */
public class OptionalBasic2Test {
    public static void main(String[] args) {

        /**
         * of()
         * A primeira abordagem para criar Optionals é usar o .of()
         * método, passando uma referência para um objeto não null :
         *
         * */
        Spaceship falcon = new Spaceship();
        Optional<Spaceship> optionalFalcon = Optional.of(falcon);
        System.out.println(optionalFalcon);


        Spaceship falcon1 = null;
        Optional<Spaceship> optionalFalcon2 = Optional.ofNullable(falcon1);
        System.out.println(optionalFalcon2);


        Spaceship falcon2 = null;
        Optional<Spaceship> optionalFalcon3 = Optional.of(falcon2);

    }

}

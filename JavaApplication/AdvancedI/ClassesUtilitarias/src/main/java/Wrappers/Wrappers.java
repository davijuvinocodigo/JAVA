package Wrappers;

/**
 * Wrappers vem do verbo inglês “wrap” que significa envolver. Eles são um nome adicional ao padrão de projeto Decorator.
 * Tem como principal função “envolver coisas” adicionando funcionalidades à ela.
 *
 * O Java conta com diversos Wrappers que adicionam funcionalidades a outras classes ou tipos primitivos,
 * um exemplo dele é o Integer, que é o Wrapper do tipo primitivo int.
 * Que tipo de funcionalidade você pode executar tendo apenas uma variável definida como “int”? Nenhuma, a não ser atribuir valores,
 * pois int é um tipo primitivo e não possuí métodos.
 */

/**
 * O uso de classes wrappers é importante quando precisamos encapsular tipos primitivos,
 * de modo que eles possam participar de funcionalidades relacionadas à orientação a objetos.
 * Um exemplo disso é seu uso em operações com collections.
 */
public class Wrappers {

    /**
     * Tipos primitivos relacionado ao tamanho do espaço em memorio.
      */

    byte bytePrimitivo =1;
    short shortPrimitivo = 1;
    int intPrimitivo =1;
    long longPrimitivo =10;
    float floatPrimitivo =10F;
    double doublePrimitivo =10D;
    char charPrimitivo ='W';
    boolean booleanPrimitivo =false;

    /**
     * Wrappers encapsula os tipos primitivos e transforma em objetos,
     * que são passados valores por referencia.
     * que são podemos usar os metodos deste objeto.
     */

    Byte byteWrappers = 127;
    Short shortWrapper = 1;
    Integer intWrappers = 1;
    Long longWrappers = 10L;
    Float floatWrappers = 10F;
    Double doubleWrappers = 10D;
    Character charWrappers = 'W';
    Boolean booleanWrappers = false;


}

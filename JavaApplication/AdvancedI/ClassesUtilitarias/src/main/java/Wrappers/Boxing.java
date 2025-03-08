package Wrappers;


public class Boxing {
    public static void main(String[] args) {

        /**
         * autoboxing quando o java faz a conversão de forma automatica dos tipos primitivos para um wrappers
         */
        Integer inteiro = 1;

        /**
         * unboxing quando a conversão e dos tipos wrappers para os tipos primitivos
         */
        int i = inteiro;

        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isDigit('a'));
        System.out.println(Character.isUpperCase('a'));
    }
}

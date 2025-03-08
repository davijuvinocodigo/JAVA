package Reference.Instance;

import java.util.function.Consumer;

/**
 * O exemplo a seguir mostra como usar o receptor vinculado e o método com parâmetros
 * para criar referências de método de instância.
 *
 * */
public class ReferenceInstanceCreateBasicTest {
    public static void main(String[] argv){
        Util util = new Util();

        Consumer<String> consumer  = str ->  util.print(str);
        consumer.accept("Hello");


        Consumer<String> consumer1  = util::print;
        consumer1.accept("java2s.com");

        util.debug();
    }
}
class Util{
    private int count=0;
    public void print(String s){
        System.out.println(s);
        count++;
    }
    public void debug(){
        System.out.println("count:" + count);
    }
}


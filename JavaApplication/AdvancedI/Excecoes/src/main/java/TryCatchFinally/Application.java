package TryCatchFinally;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        boolean continua = true;

        do {
            try {

                System.out.print("Num: ");
                int a = s.nextInt();
                System.out.print("Divisor: ");
                int b = s.nextInt();
                System.out.println(a / b);
                continua = false;
            }
            catch (InputMismatchException e1){
                System.err.println("Capturei erro InputMismatchException");
            }
            catch (ArithmeticException e2){
                System.err.println("Capturei erro ArithmeticException");
            }
            finally {
                System.out.println("Sempre eu vou executar!!!!!!! Para limpar variavies, conexao etc.....");
            }
        } while (continua);



    }
}

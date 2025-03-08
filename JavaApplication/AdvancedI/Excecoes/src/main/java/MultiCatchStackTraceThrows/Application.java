package MultiCatchStackTraceThrows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Customization {

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
            catch (InputMismatchException | ArithmeticException e1){
                System.err.println("Capturei erro");
                e1.printStackTrace();
                s.nextLine();
            }
            catch (IncompatibleClassChangeError e2){
                throw new Customization("Exception customizada");
            }
            finally {
                System.out.println("Sempre eu vou executar!!!!!!! Para limpar variavies, conexao etc.....");
            }
        } while (continua);



    }
}

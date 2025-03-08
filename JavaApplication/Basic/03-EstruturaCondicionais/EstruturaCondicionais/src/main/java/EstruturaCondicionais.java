public class EstruturaCondicionais {
    public static void main(String[] args) {
        int idade = 15;
        boolean result = idade >= 18;
        if (result) {
            System.out.println("autorizado");
        }
        if (!result) {
            System.out.println("não autorizado");
        }


        //===================================================================
        // Operador Ternario:
        boolean ternario = idade > 15 ? true : false;

        System.out.println("Ternario: " + ternario);



        //===================================================================
        // Switch

        switch (idade) {

            case 15:
                System.out.println("OK");
                break;
            case 18:
                System.out.println("Errouuuu");
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }


        //===================================================================
        // while, do while

        int count = 0;
        while (count < 10) {
            System.out.println(count++);
        }

        // executar pelo menos 1 vez
        count = 0;
        do {
            System.out.println("dentro do do-while" + count++);
        } while (count < 10);

        // for com break
        int valorMax = 50;
        for (int i=0; i<= valorMax; i++){
            if (i>50){
                break;
            }
            System.out.println(i);
        }

        // for com continue
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        }

    }
}


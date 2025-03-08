package Strings;


public class Performance {
    public static void main(String[] args) {

        /**
         * Performance com classes java como StringBuffer ou StringBuilder
         */

        long inicio = System.currentTimeMillis();
        performanceString(100000);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para strings " + (fim - inicio) + "ms" );


        long inicio2 = System.currentTimeMillis();
        performanceStringBuilder(100000);
        long fim2 = System.currentTimeMillis();
        System.out.println("Tempo gasto para builder " + (fim2 - inicio2) + "ms" );

        long inicio3 = System.currentTimeMillis();
        performanceStringBuffer(100000);
        long fim3 = System.currentTimeMillis();
        System.out.println("Tempo gasto para buffer " + (fim3 - inicio3) + "ms" );


    }

    private static void performanceString(int tamanho){
        String texto = "";
        for (int i = 0; i < tamanho; i++){
            texto += i;
        }
    }

    private static void performanceStringBuilder(int tamanho){
        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++){
            sb.append(i);
        }
    }

    private static void performanceStringBuffer(int tamanho){
        StringBuffer sb = new StringBuffer(tamanho);
        for (int i = 0; i < tamanho; i++){
            sb.append(i);
        }
    }
}

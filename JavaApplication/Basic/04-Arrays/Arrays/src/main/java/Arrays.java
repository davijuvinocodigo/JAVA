public class Arrays {
    public static void main(String[] args) {
        //Arrays estaticos
        String[] nomes = {"KK"};

        // for indexado
        for (int i=0; i< nomes.length; i++){
            System.out.println(nomes[i]);
        }

        // for sem o index
        for (String v: nomes) {
            System.out.println(v);
        }


        //========================================================
        //Arrays Multidimensionais
        int [][] dias = new int[3][3];
        dias[0][0] = 31;
        dias[0][1] = 31;
        dias[0][2] = 31;

        for (int i=0; i< dias.length-2; i++){
            for (int j=0; j< dias[i].length; j++){
                System.out.println(dias[i][j]);
            }
        }

        //Arrays Multidimensionais foreach
        System.out.println("-------------------------------------------------");
        for (int[] ref : dias) {
            for (int type : ref ) {
                System.out.println(type);
            }
        }
    }
}

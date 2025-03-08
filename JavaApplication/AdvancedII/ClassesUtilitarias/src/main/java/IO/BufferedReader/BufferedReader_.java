package IO.BufferedReader;

import java.io.*;

public class BufferedReader_ {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try (FileReader fr = new FileReader(file)) {
            BufferedReader bw = new BufferedReader(fr);
            String linha;
            while ((linha = bw.readLine()) != null){
                System.out.print(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

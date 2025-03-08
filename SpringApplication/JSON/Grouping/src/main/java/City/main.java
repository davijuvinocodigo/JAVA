package City;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class main {

    public static List<String> groupByCitys(Data data){
        List<String> values = new ArrayList<>();
        
        return values;
    }
    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
            String file = "src/main/resources/GroupByCity.json";
            String json = new String(Files.readAllBytes(Paths.get(file)));
            Data data = gson.fromJson(json, Data.class);
            String j = gson.toJson(data);
            System.out.println(j);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

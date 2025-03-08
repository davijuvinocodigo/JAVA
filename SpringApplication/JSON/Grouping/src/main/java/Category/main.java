package Category;

import Category.model.OffersData;
import Category.util.GroupingUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
            String file = "src/main/resources/GroupByCategories.json";
            String json = new String(Files.readAllBytes(Paths.get(file)));
            OffersData offersData = gson.fromJson(json, OffersData.class);
            String j = gson.toJson(GroupingUtils.convertOfferDataResponseToSimplePageableTemplate(offersData));
            System.out.println(j);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

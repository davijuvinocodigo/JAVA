package Category.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class OffersData {

    @JsonProperty("offers_data")
    private List<Category> offers;
}

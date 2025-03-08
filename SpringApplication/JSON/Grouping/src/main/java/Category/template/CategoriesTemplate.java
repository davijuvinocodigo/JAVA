package Category.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoriesTemplate {

    @JsonProperty("categoriesId")
    private String categoriesId;

    @JsonProperty("categoriesName")
    private String categoriesName;

    @JsonProperty("categoriesKey")
    private String categoriesKey;

    @JsonProperty("hits")
    private int hits;

    @JsonProperty("bytes")
    private int bytes;
}

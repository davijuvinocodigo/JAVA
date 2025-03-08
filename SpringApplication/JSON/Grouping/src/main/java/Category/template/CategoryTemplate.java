package Category.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryTemplate {

    @JsonProperty("categoryId")
    private String categoryId;

    @JsonProperty("documents")
    private String documents;

    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("categories")
    private List<CategoriesTemplate> categories;
}

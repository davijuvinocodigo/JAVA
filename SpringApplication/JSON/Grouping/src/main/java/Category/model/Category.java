package Category.model;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {

    @JsonProperty("category_name")
    private String category_name;
    @JsonProperty("category_doc")
    private String category_doc;
    @JsonProperty("category_chv")
    private String category_chv;
    @JsonProperty("hits")
    private int hits;
    @JsonProperty("bytes")
    private int bytes;
}

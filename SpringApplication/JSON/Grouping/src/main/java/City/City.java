package City;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City {

    @JsonProperty("id")
    private int id;
    @JsonProperty("business_name")
    private String business_name;
    @JsonProperty("city")
    private String city;
    @JsonProperty("city_cod")
    private int city_cod;
}

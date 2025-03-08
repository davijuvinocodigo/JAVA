package Category.model;

import Category.template.CategoryTemplate;
import Category.template.PaginationTemplate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryResponse {

    @JsonProperty("_pageable")
    private PaginationTemplate pageable = null;

    @JsonProperty("_content")
    private List<CategoryTemplate> content = new ArrayList<>();
}

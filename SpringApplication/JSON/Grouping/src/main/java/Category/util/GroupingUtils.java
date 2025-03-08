package Category.util;

import Category.model.Category;
import Category.model.CategoryResponse;
import Category.model.OffersData;
import Category.template.CategoriesTemplate;
import Category.template.CategoryTemplate;
import Category.template.PaginationTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupingUtils {

    public static CategoryResponse convertOfferDataResponseToSimplePageableTemplate(OffersData offers) {
        CategoryResponse pageableTemplate = new CategoryResponse();
        pageableTemplate.setPageable(defineMoreElementsInPageable());
        pageableTemplate.setContent(convertListOfferDataResponseToListCategory(offers.getOffers()));
        return pageableTemplate;
    }

    private static List<CategoryTemplate> convertListOfferDataResponseToListCategory(List<Category> offers) {
        List<CategoryTemplate> listCategory = new ArrayList<>();
        offers.stream().forEach((Category c) -> resolveListCategory(listCategory, c));
        return listCategory;
    }

    private static void resolveListCategory(List<CategoryTemplate> listCategory, Category c) {
        if(isDuplicateCategory(listCategory, c)) {
            addNewCategories(listCategory, c);
        } else {
            listCategory.add(convertCategoryResponseToCategories(c));
        }
    }

    private static void addNewCategories(List<CategoryTemplate> listCategory, Category c) {
        listCategory.stream()
                .filter((CategoryTemplate element) -> element.getDocuments().equals(c.getCategory_doc()) &&
                        (!denyDuplicateCategories(element.getCategories(), c)))
                .findFirst()
                .orElse(CategoryTemplate.builder()
                        .categories(new ArrayList<>()).build())
                .getCategories().add(createCategories(c));
    }

    private static boolean denyDuplicateCategories(List<CategoriesTemplate> categories, Category c) {
        return categories.stream().filter(
                (CategoriesTemplate element) -> element.getCategoriesKey().equals(c.getCategory_chv())).collect(Collectors.toList()).size()>0;
    }

    private static CategoriesTemplate createCategories(Category c) {
        CategoriesTemplate categories = new CategoriesTemplate();
        categories.setCategoriesId(Hash256Utils.generateHash256String(c.getCategory_chv()));
        categories.setCategoriesName(c.getCategory_name());
        categories.setCategoriesKey(c.getCategory_chv());
        categories.setHits(c.getHits());
        categories.setBytes(c.getBytes());
        return categories;
    }

    private static CategoryTemplate convertCategoryResponseToCategories(Category c) {
        return CategoryTemplate.builder()
                .categoryId(Hash256Utils.generateHash256String(c.getCategory_doc()))
                .categoryName(c.getCategory_name())
                .documents(c.getCategory_doc())
                .categories(convertCategoryResponseToListCategories(c))
                .build();
    }

    private static List<CategoriesTemplate> convertCategoryResponseToListCategories(Category c) {
        List<CategoriesTemplate> categories = new ArrayList<>();
        categories.add(createCategories(c));
        return categories;
    }

    private static boolean isDuplicateCategory(List<CategoryTemplate> listCategory, Category c) {
        return listCategory.stream().filter(
                (CategoryTemplate element) -> element.getDocuments().equals(c.getCategory_doc()))
                .collect(Collectors.toList()).size()>0;
    }

    private static PaginationTemplate defineMoreElementsInPageable() {
        PaginationTemplate pageable = new PaginationTemplate();
        pageable.setMoreElements(Boolean.TRUE);
        return pageable;
    }


}

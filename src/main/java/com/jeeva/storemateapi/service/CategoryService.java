package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Categories;
import java.util.Optional;


public interface CategoryService {
    Optional<Categories> getCategoryById(Integer id);
    Optional<Categories> getCategoryByName(String name);
    Iterable<Categories> getAllCategories();
    Categories createCategory(Categories category);
    Categories updateCategory(Integer id, Categories updatedCategory);
    void deleteCategory(Integer id);
}
package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Categories;
import com.jeeva.storemateapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Categories> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Categories createCategory(Categories category) {
        return categoryRepository.save(category);
    }

    @Override
    public Categories updateCategory(Integer id, Categories updatedCategory) {
        if (categoryRepository.existsById(id)) {
            updatedCategory.setCategoryId(id);
            return categoryRepository.save(updatedCategory);
        }
        return null;
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
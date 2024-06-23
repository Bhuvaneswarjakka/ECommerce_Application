package com.Bhuvaneswar.ECommerce_Application.Service;

import com.Bhuvaneswar.ECommerce_Application.DTOs.CategoryResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.CreateCategoryRequestDTO;
import com.Bhuvaneswar.ECommerce_Application.Exceptions.CategoryNotFoundException;
import com.Bhuvaneswar.ECommerce_Application.Mapper.CategoryEntityDTOMapper;
import com.Bhuvaneswar.ECommerce_Application.Repository.CategoryRepository;
import com.Bhuvaneswar.ECommerce_Application.entity.Category;
import com.Bhuvaneswar.ECommerce_Application.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDTO> getAllCategories()
    {
        List<Category> categories=categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOS=new ArrayList<>();
        for(Category c: categories)
        {
            categoryResponseDTOS.add(CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(c));
        }
        return categoryResponseDTOS;

    }

    @Override
    public CategoryResponseDTO getCategoryById(UUID categoryId)
    {
        Category category=categoryRepository.findById(categoryId).orElseThrow(
                ()-> new CategoryNotFoundException("Category with id "+categoryId+ " is not found")
        );
        return CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO createCategoryRequestDTO)
    {
        Category category=CategoryEntityDTOMapper.convertCreateCategoryDTOToCategory(createCategoryRequestDTO);
        categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category);
    }


    @Override
    public CategoryResponseDTO updateCategory(UUID categoryId, CreateCategoryRequestDTO createCategoryRequestDTO)
    {
        return null;
    }

    @Override
    public boolean deleteCategory(UUID categoryId)
    {
        return false;
    }

    @Override
    public double totalPriceOfParticularCategory(UUID categoryId)
    {
        Category category=categoryRepository.findById(categoryId).orElseThrow(
                ()-> new CategoryNotFoundException("Category with id "+categoryId+ " is not found")
        );
        if(category.getProducts().isEmpty())
        {
            return 0.0;
        }
        else
        {
            double sum=0.0;
            for(Product product:category.getProducts())
            {
                sum=sum+product.getPrice();
            }
            return sum;
        }
    }
}

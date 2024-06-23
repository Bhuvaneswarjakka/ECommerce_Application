package com.Bhuvaneswar.ECommerce_Application.Service;

import com.Bhuvaneswar.ECommerce_Application.DTOs.CategoryResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.CreateCategoryRequestDTO;
import com.Bhuvaneswar.ECommerce_Application.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService
{
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO getCategoryById(UUID categoryId);
    CategoryResponseDTO createCategory(CreateCategoryRequestDTO createCategoryRequestDTO);
    CategoryResponseDTO updateCategory(UUID categoryId, CreateCategoryRequestDTO createCategoryRequestDTO);
    boolean deleteCategory(UUID categoryId);
    double totalPriceOfParticularCategory(UUID categoryId);
}

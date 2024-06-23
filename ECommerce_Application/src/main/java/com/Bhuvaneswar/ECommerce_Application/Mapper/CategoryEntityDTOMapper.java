package com.Bhuvaneswar.ECommerce_Application.Mapper;

import com.Bhuvaneswar.ECommerce_Application.DTOs.CategoryResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.CreateCategoryRequestDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.ProductResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.entity.Category;
import com.Bhuvaneswar.ECommerce_Application.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityDTOMapper
{
    public static CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category)
    {
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setId(category.getId());
        categoryResponseDTO.setCategoryName(category.getCategoryName());
        List<ProductResponseDTO> productResponseDTO=new ArrayList<>();
        if(!(category.getProducts()==null || category.getProducts().isEmpty()))
        {
            for(Product p:category.getProducts())
            {
                productResponseDTO.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(p));
            }
        }
        categoryResponseDTO.setProducts(productResponseDTO);
        return categoryResponseDTO;
    }

    public static Category convertCreateCategoryDTOToCategory(CreateCategoryRequestDTO createCategoryRequestDTO)
    {
        Category category=new Category();
        category.setCategoryName(createCategoryRequestDTO.getCategoryName());
        return category;
    }
}

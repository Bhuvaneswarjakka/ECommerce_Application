package com.Bhuvaneswar.ECommerce_Application.Mapper;

import com.Bhuvaneswar.ECommerce_Application.DTOs.ProductRequestDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.ProductResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.entity.Product;

public class ProductEntityDTOMapper
{
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product)
    {
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setImageURL(product.getImageURL());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setCategory(product.getCategory().getCategoryName());
        return productResponseDTO;
    }

    public static Product convertCreateProductRequestDTOToEntity(ProductRequestDTO productRequestDTO)
    {
        Product product=new Product();
        product.setTitle(productRequestDTO.getTitle());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());
        product.setImageURL(productRequestDTO.getImageURL());
        return product;
    }
}

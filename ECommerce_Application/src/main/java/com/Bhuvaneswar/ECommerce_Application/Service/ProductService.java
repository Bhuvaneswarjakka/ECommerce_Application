package com.Bhuvaneswar.ECommerce_Application.Service;

import com.Bhuvaneswar.ECommerce_Application.DTOs.ProductRequestDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.ProductResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService
{
    /*
    FakeStore:

    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO getProduct(int productId);
    Product createProduct(Product product);
    Product updateProduct(Product product, int productId);
    boolean deleteProduct(int productId);

     */

    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(UUID productId);
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO updateProduct(ProductRequestDTO product, UUID productId);
    boolean deleteProduct(UUID productId);

}

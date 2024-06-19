package com.Bhuvaneswar.ECommerce_Application.Service;

import com.Bhuvaneswar.ECommerce_Application.DTOs.FakeStoreProductResponseDTO;
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

    List<Product> getAllProducts();
    Product getProduct(UUID productId);
    Product createProduct(Product product);
    Product updateProduct(Product product, UUID productId);
    boolean deleteProduct(UUID productId);

}

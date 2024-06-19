package com.Bhuvaneswar.ECommerce_Application.Service;
import com.Bhuvaneswar.ECommerce_Application.Repository.ProductRepository;
import com.Bhuvaneswar.ECommerce_Application.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productServiceOurOwn")
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products=productRepository.findAll();
        return products;
    }

    @Override
    public Product getProduct(int productId) {
        Product product=productRepository.findById(productId).get();
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct=productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}

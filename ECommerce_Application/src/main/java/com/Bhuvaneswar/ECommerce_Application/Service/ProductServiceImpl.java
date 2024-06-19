package com.Bhuvaneswar.ECommerce_Application.Service;
import com.Bhuvaneswar.ECommerce_Application.Exceptions.productNotFoundException;
import com.Bhuvaneswar.ECommerce_Application.Repository.ProductRepository;
import com.Bhuvaneswar.ECommerce_Application.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public Product getProduct(UUID productId)
    {
        /*
        Product product=productRepository.findById(productId).get();
        if(product==null)
        {
            throw new productNotFoundException("Product is not present with productId: "+productId);
        }
        return product;
         */
        return productRepository.findById(productId).orElseThrow(
                ()-> new productNotFoundException("Product Not found for id: "+productId)
        );
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct=productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product, UUID productId)
    {
        Product product1=productRepository.findById(productId).orElseThrow(
                ()->new productNotFoundException("Product is not found with id: "+productId)
        );
        product1.setTitle(product.getTitle());
//        product1.setCategory(product.getCategory());
        product1.setRating(product.getRating());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setImageURL(product.getImageURL());
        Product savedProduct=productRepository.save(product1);
        return savedProduct;
    }

    @Override
    public boolean deleteProduct(UUID productId)
    {
        productRepository.deleteById(productId);
        return true;
    }
}

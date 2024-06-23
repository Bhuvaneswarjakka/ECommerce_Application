package com.Bhuvaneswar.ECommerce_Application.Service;
import com.Bhuvaneswar.ECommerce_Application.DTOs.ProductRequestDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.ProductResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.Exceptions.CategoryNotFoundException;
import com.Bhuvaneswar.ECommerce_Application.Exceptions.productNotFoundException;
import com.Bhuvaneswar.ECommerce_Application.Mapper.ProductEntityDTOMapper;
import com.Bhuvaneswar.ECommerce_Application.Repository.CategoryRepository;
import com.Bhuvaneswar.ECommerce_Application.Repository.ProductRepository;
import com.Bhuvaneswar.ECommerce_Application.entity.Category;
import com.Bhuvaneswar.ECommerce_Application.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productServiceOurOwn")
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products=productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS=new ArrayList<>();
        for(Product p:products)
        {
            productResponseDTOS.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(p));
        }
        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO getProduct(UUID productId)
    {
        /*
        Product product=productRepository.findById(productId).get();
        if(product==null)
        {
            throw new productNotFoundException("Product is not present with productId: "+productId);
        }
        return ProductEntityDTOMapper.convertProductToProductResponseDTO(product);
         */

        Product product=productRepository.findById(productId).orElseThrow(
                ()-> new productNotFoundException("Product Not found for id: "+productId)
        );
        ProductResponseDTO productResponseDTO=ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) throws CategoryNotFoundException
    {
        Product product=ProductEntityDTOMapper.convertCreateProductRequestDTOToEntity(productRequestDTO);
        Category category=categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(
                ()-> new CategoryNotFoundException("Category not found for id: "+ productRequestDTO.getCategoryId())
        );
        product.setCategory(category);
        productRepository.save(product);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, UUID productId)
    {
        Product product1=productRepository.findById(productId).orElseThrow(
                ()->new productNotFoundException("Product is not found with id: "+productId)
        );
        product1.setTitle(productRequestDTO.getTitle());
        product1.setDescription(productRequestDTO.getDescription());
        product1.setPrice(productRequestDTO.getPrice());
        product1.setImageURL(productRequestDTO.getImageURL());
        Product savedProduct=productRepository.save(product1);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId)
    {
        productRepository.deleteById(productId);
        return true;
    }
}

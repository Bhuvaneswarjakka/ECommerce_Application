package com.Bhuvaneswar.ECommerce_Application.controller;
import com.Bhuvaneswar.ECommerce_Application.DTOs.ProductRequestDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.ProductResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.Exceptions.InvalidInputException;
import com.Bhuvaneswar.ECommerce_Application.Service.ProductService;
import com.Bhuvaneswar.ECommerce_Application.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController
{
/*
    @Autowired
    @Qualifier("productServiceFakeStore")
    private ProductService productService; //field Injection

    @GetMapping("/product")
    public ResponseEntity getAllProducts()
    {
        List<FakeStoreProductResponseDTO> products=productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProduct(@PathVariable("id") int productId) throws InvalidInputException
    {
        if(productId<1)
        {
            throw new InvalidInputException
                    ("Input is Invalid of productId "+productId);
        }
        FakeStoreProductResponseDTO product=productService.getProduct(productId);
        return ResponseEntity.ok(product);
    }


*/
    @Autowired
    @Qualifier("productServiceOurOwn")
    private ProductService productService; //field Injection

    @Cacheable(value = "product")
    @GetMapping("/product")
    public List<ProductResponseDTO> getAllProducts()
    {
        List<ProductResponseDTO> products=productService.getAllProducts();
        return products;
    }

    @Cacheable(value = "product" , key = "#id")
    @GetMapping("/product/{id}")
    public ProductResponseDTO getProduct(@PathVariable("id") UUID id)
    {
        if(id==null)
        {
            throw new InvalidInputException
                    ("Input is Invalid of productId "+id);
        }
        ProductResponseDTO product=productService.getProduct(id);
        return product;
    }

    @PostMapping("/product/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        ProductResponseDTO p=productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(p);
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody ProductRequestDTO productRequestDTO, @PathVariable("id") UUID productId)
    {
        ProductResponseDTO p=productService.updateProduct(productRequestDTO, productId);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") UUID productId)
    {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }
}

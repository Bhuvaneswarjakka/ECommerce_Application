package com.Bhuvaneswar.ECommerce_Application.controller;
import com.Bhuvaneswar.ECommerce_Application.DTOs.FakeStoreProductResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.ProductResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.Exceptions.InvalidInputException;
import com.Bhuvaneswar.ECommerce_Application.Service.ProductService;
import com.Bhuvaneswar.ECommerce_Application.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @GetMapping("/product")
    public ResponseEntity getAllProducts()
    {
        List<Product> products=productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProduct(@PathVariable("id") UUID productId) throws InvalidInputException
    {
        if(productId==null)
        {
            throw new InvalidInputException
                    ("Input is Invalid of productId "+productId);
        }
        Product product=productService.getProduct(productId);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/product/create")
    public ResponseEntity createProduct(@RequestBody Product product)
    {
        Product p=productService.createProduct(product);
        return ResponseEntity.ok(p);
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity updateProduct(@RequestBody Product product, @PathVariable("id") UUID productId)
    {
        Product p=productService.updateProduct(product, productId);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID productId)
    {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }
}

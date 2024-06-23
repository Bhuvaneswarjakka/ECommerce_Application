package com.Bhuvaneswar.ECommerce_Application.controller;

import com.Bhuvaneswar.ECommerce_Application.DTOs.CategoryResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.CreateCategoryRequestDTO;
import com.Bhuvaneswar.ECommerce_Application.Service.CategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories()
    {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id") UUID categoryId)
    {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CreateCategoryRequestDTO createCategoryRequestDTO)
    {
        CategoryResponseDTO categoryResponseDTO= categoryService.createCategory(createCategoryRequestDTO);
        return ResponseEntity.ok(categoryResponseDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable("id") UUID categoryId, @RequestBody CreateCategoryRequestDTO createCategoryRequestDTO)
    {
        return ResponseEntity.ok(categoryService.updateCategory(categoryId, createCategoryRequestDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") UUID categoryId)
    {
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }

    @GetMapping("/totalPrice/{id}")
    public ResponseEntity<Double> getTotalPriceForAllProducts(@PathVariable("id") UUID categoryId)
    {
        return ResponseEntity.ok(categoryService.totalPriceOfParticularCategory(categoryId));
    }
}

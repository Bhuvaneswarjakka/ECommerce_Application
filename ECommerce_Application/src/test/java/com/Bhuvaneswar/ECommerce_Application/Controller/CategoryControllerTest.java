package com.Bhuvaneswar.ECommerce_Application.Controller;

import com.Bhuvaneswar.ECommerce_Application.DTOs.CategoryResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.CreateCategoryRequestDTO;
import com.Bhuvaneswar.ECommerce_Application.Service.CategoryService;
import com.Bhuvaneswar.ECommerce_Application.controller.CategoryController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class CategoryControllerTest
{
    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void updateCategoryTest()
    {
        //Arrange
        UUID categoryId=UUID.randomUUID();
        CreateCategoryRequestDTO createCategoryRequestDTO=new CreateCategoryRequestDTO();
        createCategoryRequestDTO.setCategoryName("AnyData");

        /*
        public class CreateCategoryRequestDTO
        {
            private String categoryName;
        }
         */

        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setId(UUID.randomUUID());
        categoryResponseDTO.setCategoryName("AnyName");

        /*
        public class CategoryResponseDTO
        {
            private UUID Id;
            private String categoryName;
            private List<ProductResponseDTO> products;
        }
         */

        Mockito.when(categoryService.updateCategory(categoryId, createCategoryRequestDTO)).thenReturn(categoryResponseDTO);

        //Act
        ResponseEntity<CategoryResponseDTO> actual=categoryController.updateCategory(categoryId, createCategoryRequestDTO);

        //Assert-->Checks
        Assertions.assertEquals(actual.getBody(), categoryResponseDTO);

    }

}

/*

    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable("id") UUID categoryId, @RequestBody CreateCategoryRequestDTO createCategoryRequestDTO)
    {
        return ResponseEntity.ok(categoryService.updateCategory(categoryId, createCategoryRequestDTO));
    }

    public class CreateCategoryRequestDTO
    {
        private String categoryName;
    }

    public class CategoryResponseDTO
    {
        private UUID Id;
        private String categoryName;
        private List<ProductResponseDTO> products;
    }


 */

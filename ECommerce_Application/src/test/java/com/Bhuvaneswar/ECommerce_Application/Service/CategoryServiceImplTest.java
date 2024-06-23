package com.Bhuvaneswar.ECommerce_Application.Service;

import com.Bhuvaneswar.ECommerce_Application.Exceptions.CategoryNotFoundException;
import com.Bhuvaneswar.ECommerce_Application.Repository.CategoryRepository;
import com.Bhuvaneswar.ECommerce_Application.entity.Category;
import com.Bhuvaneswar.ECommerce_Application.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest
{
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.initMocks(this); //Not compulsory to mention this
    }

    @Test
    public void testGetTotalPriceForParticularCategory()
    {
        //Arrange
        UUID categoryId=UUID.randomUUID();
        Optional<Category> categoryOptional=getCategoryMockData();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryOptional);
        double expectedTotalCost=1000.00;

        //Act
        double actualTotalCost=categoryService.totalPriceOfParticularCategory(categoryId);

        //Assert-->Checks
        Assertions.assertEquals(actualTotalCost, expectedTotalCost);
    }

    public Optional<Category> getCategoryMockData()
    {
        //category have id, name, List<Products> in Actual DB
        Category category=new Category();
        category.setId(UUID.randomUUID());
        category.setCategoryName("AnyName");

        Product product=new Product();
        product.setId(UUID.randomUUID());
        product.setTitle("product1");
        product.setPrice(200.00);
        product.setCategory(category);

        Product product2=new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("product2");
        product2.setPrice(800.00);
        product2.setCategory(category);

        List<Product> products=new ArrayList<>();
        products.add(product);
        products.add(product2);

        category.setProducts(products);
        return Optional.of(category);
    }

    @Test
    public void testGetTotalPriceForZeroProductsOfCategory()
    {
        //Arrange
        UUID categoryId=UUID.randomUUID();
        Optional<Category> categoryOptional=getCategoryZeroProductsMockData();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryOptional);
        double expectedTotalCost=0.00;

        //Act
        double actualTotalCost=categoryService.totalPriceOfParticularCategory(categoryId);

        //Asset
        Assertions.assertEquals(actualTotalCost, expectedTotalCost);
        Mockito.verify(categoryRepository).findById(categoryId);
    }

    public Optional<Category> getCategoryZeroProductsMockData()
    {
        //category have id, name, List<Products> in Actual DB
        Category category=new Category();
        category.setId(UUID.randomUUID());
        category.setCategoryName("AnyName");

        List<Product> products=new ArrayList<>();

        category.setProducts(products);
        return Optional.of(category);
    }

    @Test
    public void testCategoryNotFoundExceptionThrown()
    {
        //Arrange
        UUID categoryId=UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        //Act
        //Assert-->Checks
        Assertions.assertThrows(CategoryNotFoundException.class,
                ()-> categoryService.totalPriceOfParticularCategory(categoryId));
    }
}

package com.Bhuvaneswar.ECommerce_Application.DTOs;

import com.Bhuvaneswar.ECommerce_Application.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductRequestDTO
{
    private String title;
    private double price;
    private String description;
    private String imageURL;
    private UUID categoryId;//we need to specify that product is belong to which category also right.
}

package com.Bhuvaneswar.ECommerce_Application.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryResponseDTO
{
    private UUID Id;
    private String categoryName;
    private List<ProductResponseDTO> products;
}


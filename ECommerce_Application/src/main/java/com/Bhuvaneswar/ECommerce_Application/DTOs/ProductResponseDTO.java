package com.Bhuvaneswar.ECommerce_Application.DTOs;


import com.Bhuvaneswar.ECommerce_Application.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
public class ProductResponseDTO
{
    private int id;
    private Instant createdAt;
    private Instant updatedAt;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;

}
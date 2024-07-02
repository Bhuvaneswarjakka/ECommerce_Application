package com.Bhuvaneswar.ECommerce_Application.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO implements Serializable
{
    private UUID productId;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
}

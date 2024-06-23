package com.Bhuvaneswar.ECommerce_Application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseModel
{
    private String title;
    private double price;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String imageURL;
    private double rating;
}

/*
product    category
  1            1
  M            1
--------------------
  M      :     1
 */
package com.Bhuvaneswar.ECommerce_Application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel
{
    private String name;
    @OneToMany
    private List<Product> products;
}

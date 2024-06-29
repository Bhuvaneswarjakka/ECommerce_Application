package com.Bhuvaneswar.Payment_Microservice_ECommerce.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Currency extends BaseModel
{
    private String currencyTag; //INR, USD etc.,
    private String currencyName; //Indian rupees, dollars
    private String country;// INDIA, AMERICA etc
}

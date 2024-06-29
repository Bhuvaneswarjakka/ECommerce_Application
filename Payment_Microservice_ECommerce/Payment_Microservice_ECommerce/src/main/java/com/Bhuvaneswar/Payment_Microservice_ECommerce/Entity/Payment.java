package com.Bhuvaneswar.Payment_Microservice_ECommerce.Entity;

import com.Bhuvaneswar.Payment_Microservice_ECommerce.Entity.Enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Payment extends BaseModel
{
    private double amount;
    private UUID orderId;
    private UUID userId;
    private String transactionId;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @OneToMany
    private Currency currency;
}

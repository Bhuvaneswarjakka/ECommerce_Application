package com.Bhuvaneswar.Payment_Microservice_ECommerce.Repository;

import com.Bhuvaneswar.Payment_Microservice_ECommerce.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}

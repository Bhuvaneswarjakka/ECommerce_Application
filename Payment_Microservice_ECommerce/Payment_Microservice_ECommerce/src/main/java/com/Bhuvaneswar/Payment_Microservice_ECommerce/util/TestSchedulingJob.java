package com.Bhuvaneswar.Payment_Microservice_ECommerce.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TestSchedulingJob
{
    @Scheduled(cron = "*/5 * * * * *")
    public void printName()
    {
        System.out.println("Bhuvaneswar "+ LocalDateTime.now());
    }
}

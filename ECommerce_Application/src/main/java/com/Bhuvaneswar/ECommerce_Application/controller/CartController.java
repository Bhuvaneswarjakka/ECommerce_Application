package com.Bhuvaneswar.ECommerce_Application.controller;

import com.Bhuvaneswar.ECommerce_Application.DTOs.FakeStoreDTOs.FakeStoreCartForUserResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.Exceptions.InvalidInputException;
import com.Bhuvaneswar.ECommerce_Application.Exceptions.NoCartFoundWithUserException;
import com.Bhuvaneswar.ECommerce_Application.client.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController
{
    @Autowired
    private FakeStoreClient fakeStoreClient;

    @GetMapping("/cart/{id}")
    public ResponseEntity getCartForUser(@PathVariable("id") int userId)
    {
        if(userId<1)
        {
            throw new InvalidInputException("Input is Invalid for userId: "+userId);
        }
        List<FakeStoreCartForUserResponseDTO> cartResponse=fakeStoreClient.getCartForUser(userId);
        if(cartResponse==null)
        {
            throw new NoCartFoundWithUserException("No Cart Found For User with Id: "+userId);
        }
        return ResponseEntity.ok(cartResponse);
    }
}

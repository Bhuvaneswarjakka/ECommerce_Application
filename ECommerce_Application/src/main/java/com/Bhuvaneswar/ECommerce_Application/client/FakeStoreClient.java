package com.Bhuvaneswar.ECommerce_Application.client;
import com.Bhuvaneswar.ECommerce_Application.DTOs.FakeStoreDTOs.FakeStoreCartForUserResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.DTOs.FakeStoreDTOs.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
public class FakeStoreClient
{
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseURL;
    @Value(("${fakestore.api.product.path}"))
    private String fakeStoreAPIProductPath;
    @Value("${fakestore.api.cart.for.user.path}")
    private String fakeStoreAPICartForUserPath;

    public List<FakeStoreProductResponseDTO> getAllProducts()
    {
        String fakeStoreGetAllProductURL=fakeStoreAPIBaseURL.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList =
                restTemplate.getForEntity
                        (fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }

    public FakeStoreProductResponseDTO getProduct(int productId)
    {
        String fakeStoreGetProductURL=fakeStoreAPIBaseURL.
                concat(fakeStoreAPIProductPath).
                concat("/"+productId);
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> product=
                restTemplate.getForEntity
                        (fakeStoreGetProductURL, FakeStoreProductResponseDTO.class);
        return product.getBody();
    }

    public List<FakeStoreCartForUserResponseDTO> getCartForUser(int userId)
    {
        String fakeStoreGetCartForUserURL=fakeStoreAPIBaseURL.concat(fakeStoreAPICartForUserPath).concat(String.valueOf(userId));
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartForUserResponseDTO[]> cartResponseList =
                restTemplate.getForEntity
                        (fakeStoreGetCartForUserURL, FakeStoreCartForUserResponseDTO[].class);
        return List.of(cartResponseList.getBody());
    }
}

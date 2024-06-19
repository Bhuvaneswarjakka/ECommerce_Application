package com.Bhuvaneswar.ECommerce_Application.Service;
import com.Bhuvaneswar.ECommerce_Application.DTOs.FakeStoreProductResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.Exceptions.NoProductPresentException;
import com.Bhuvaneswar.ECommerce_Application.Exceptions.productNotFoundException;
import com.Bhuvaneswar.ECommerce_Application.client.FakeStoreClient;
import com.Bhuvaneswar.ECommerce_Application.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("FakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl
{
    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDTO> getAllProducts() throws NoProductPresentException{
        List<FakeStoreProductResponseDTO> fakeStoreproducts=fakeStoreClient.getAllProducts();
        if(fakeStoreproducts==null)
        {
            throw new NoProductPresentException("No Products are found");
        }
        return fakeStoreproducts;
    }

    public FakeStoreProductResponseDTO getProduct(int productId) throws productNotFoundException{
        FakeStoreProductResponseDTO fakeStoreproduct=fakeStoreClient.getProduct(productId);
        if(fakeStoreproduct==null)
        {
            throw new productNotFoundException("only 20 products is available in the fake Store");
        }
        return fakeStoreproduct;
    }

    public Product createProduct(Product product) {
        return null;
    }

    public Product updateProduct(Product product, int productId) {
        return null;
    }

    public boolean deleteProduct(int productId) {
        return false;
    }
}

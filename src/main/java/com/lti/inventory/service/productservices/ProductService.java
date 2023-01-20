package com.lti.inventory.service.productservices;

import com.lti.inventory.model.Product;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public interface ProductService {
    public List<Product> getProducts(int factoryId);

    public List<Product> addProduct(Product product);

    public List<Product> editProduct(Product product);

    public void deleteProduct(Integer pid);
}

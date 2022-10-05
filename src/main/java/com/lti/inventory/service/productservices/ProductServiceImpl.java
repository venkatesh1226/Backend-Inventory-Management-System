package com.lti.inventory.service.productservices;

import com.lti.inventory.model.Product;
import com.lti.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository repo;
    @Override
    public List<Product> getProducts(int factoryId) {
        List<Product> items=new ArrayList<>();
        for(Product item:repo.findAll())
            if(factoryId==item.getFactoryId())
                items.add(item);

        return items;
    }

    @Override
    public List<Product> addProduct(Product product) {
        repo.save(product);
        return null;
    }

    @Override
    public List<Product> editProduct(Product product) {
        repo.deleteById(product.getProductId());
        repo.save(product);
        return repo.findAll();
    }

    @Override
    public List<Product> deleteProduct(Integer pid) {
         repo.deleteById(pid);
         return repo.findAll();
    }
}

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
            if(factoryId==item.getFactoryId()){
//                items.add(item.decompress(item));
                items.add(item);
            }
        return items;
    }

    @Override
    public List<Product> addProduct(Product product) {

//        repo.save(product.compress(product));
        repo.save((product));
        return repo.findAll();

    }

    @Override
    public List<Product> editProduct(Product p) {
//        repo.deleteById(product.getProductId());
////        repo.save(product.compress(product));
//        repo.save((product));
       repo.save(new Product(p.getProductId(),p.getProductName(),p.getQuantity(),p.getDescription(),p.getFactoryId(),p.getPicLink()));
        return repo.findAll();
    }

    @Override
    public void deleteProduct(Integer pid) {
         repo.deleteById(pid);
//         return repo.findAll();
    }
}

package com.lti.inventory.controller;

import com.lti.inventory.model.Product;
import com.lti.inventory.service.productservices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/{fid}/products")
    List<Product> getProductByClass(@PathVariable int fid){
        return service.getProducts(fid);
    }

    @PostMapping("/add-product")
    List<Product> addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @PutMapping("/edit-product")
    List<Product> editProduct(@RequestBody Product product){
        return service.editProduct(product);
    }

    @DeleteMapping("/delete/{pid}")
    List<Product> deleteProduct(@PathVariable Integer pid){
        return service.deleteProduct(pid);
    }
}

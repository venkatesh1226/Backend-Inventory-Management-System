package com.lti.inventory.controller;

import com.lti.inventory.model.Product;
import com.lti.inventory.service.productservices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PutMapping(value="/edit-product",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    List<Product> editProduct(@RequestPart Product product, @RequestPart MultipartFile file){
        try {
            product.setPic(file.getBytes());
            product.setPicName(file.getOriginalFilename());
            product.setPicType(file.getContentType());
            service.editProduct(product.compress(product));
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return service.editProduct(product);
    }

    @DeleteMapping("/delete/{pid}")
    List<Product> deleteProduct(@PathVariable Integer pid){
        return service.deleteProduct(pid);
    }
}

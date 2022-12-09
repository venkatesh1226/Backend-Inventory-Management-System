package com.lti.inventory.controller;

import com.lti.inventory.model.Attachment;
import com.lti.inventory.model.Product;
import com.lti.inventory.model.ResponseData;
import com.lti.inventory.service.attachment.AttachmentService;
import com.lti.inventory.service.productservices.ProductService;
import com.lti.inventory.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService service;
    @Autowired
    AttachmentService attachmentService;

    ImageUtils util=new ImageUtils();

    @GetMapping("/{fid}/products")
    List<Product> getProductByClass(@PathVariable int fid){
        return service.getProducts(fid);
    }

    @PostMapping("/add-product")
    List<Product> addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

//    @PutMapping(value="/edit-product",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    List<Product> editProduct(@RequestPart Product product, @RequestPart(required = false) MultipartFile file){
//        try {
//            product.setPic(file.getBytes());
//            product.setPicName(file.getOriginalFilename());
//            product.setPicType(file.getContentType());
//            service.editProduct(product.compress(product));
//        }
//        catch (Exception e){
//            System.out.println(e.toString());
//        }
//        return service.editProduct(product);
//    }

    @PutMapping(value="/edit-product")
    List<Product> editProduct(@RequestBody Product product){
        return service.editProduct(product);
    }

    @DeleteMapping("/delete/{pid}")
    List<Product> deleteProduct(@PathVariable Integer pid){
        return service.deleteProduct(pid);
    }

@PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
    Attachment attachment=null;
    String downloadURL="";
    attachment=attachmentService.saveAttachment(file);
    downloadURL= ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(attachment.getId()).toUriString();
    return downloadURL;
}

@GetMapping("/download/{fileId}")
public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception{
    Attachment attachment = attachmentService.getAttachment(fileId);
    return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(attachment.getFileType()))
            .header(HttpHeaders.CONTENT_DISPOSITION,
                   "attachment;filename=\""+attachment.getFileName()+"\"" )
            .body(new ByteArrayResource(attachment.getData()));
}
}

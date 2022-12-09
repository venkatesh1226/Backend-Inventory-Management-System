package com.lti.inventory.model;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.Arrays;

@RestController
@CrossOrigin(origins = "*")
@Entity
@Table(name = "venkatesh_product")
public class Product {

    public Product(int productId, String productName, int quantity, String description, int factoryId,  String picLink) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.description = description;
        this.factoryId = factoryId;
        this.picLink = picLink;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private int quantity;
    private String description;
    private int factoryId;

    private String picLink;


    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", factoryId=" + factoryId +
                ", picName='" + picLink + '\'' +
                '}';
    }

    public Product(){}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



//    public Product compress(Product p){
//
//        Deflater deflater = new Deflater();
//        deflater.setInput(p.pic);
//        deflater.finish();
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(p.getPic().length);
//        byte[] buffer = new byte[1024];
//        while (!deflater.finished()) {
//            int count = deflater.deflate(buffer);
//            outputStream.write(buffer, 0, count);
//        }
//        try {
//            outputStream.close();
//        } catch (IOException e) {
//        }
//        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
//
////        return outputStream.toByteArray();
//
//        return new Product(p.getProductId(),p.getProductName(), p.getQuantity(), p.getDescription(),p.getFactoryId(),outputStream.toByteArray(),p.getPicName(),p.getPicType());
//    }
//
//    public Product decompress(Product p){
//        Inflater inflater = new Inflater();
//        inflater.setInput(p.getPic());
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(getPic().length);
//        byte[] buffer = new byte[1024];
//        try {
//            while (!inflater.finished()) {
//                int count = inflater.inflate(buffer);
//                outputStream.write(buffer, 0, count);
//            }
//            outputStream.close();
//        } catch (IOException ioe) {
//        } catch (DataFormatException e) {
//        }
//
//        return new Product(p.getProductId(),p.getProductName(), p.getQuantity(), p.getDescription(),p.getFactoryId(),outputStream.toByteArray(),p.getPicName(),p.getPicType());
//    }
//
//    public String getUploadDir() {
//        return uploadDir;
//    }
//
//    public void setUploadDir(String uploadDir) {
//        this.uploadDir = uploadDir;
//    }
//
//    @Value("${app.upload.dir:${user.home}}")
//    public String uploadDir;
//
//    public void uploadFile(MultipartFile file)
//    {
//        try {
//            Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
//            Files.copy(file.getInputStream(),copyLocation, StandardCopyOption.REPLACE_EXISTING);
//
//        } catch (IOException e) {
//            e.printStackTrace();
////            throw new Exception("File Not Found");
//        }
//    }

}

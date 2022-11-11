package com.lti.inventory.model;

import org.hibernate.annotations.Type;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin(origins = "*")
@Entity
@Table(name = "venkatesh_product")
public class Product {

    public Product(int productId, String productName, int quantity, String description, int factoryId, byte[] pic, String picName, String picType) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.description = description;
        this.factoryId = factoryId;
        this.pic = pic;
        this.picName = picName;
        this.picType = picType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private int quantity;
    private String description;
    private int factoryId;

    private String picName;

    private String picType;

    @Lob
    @Column(length = 5000)
    private byte[] pic;


    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", factoryId=" + factoryId +
                ", pic=" + Arrays.toString(pic) +
                ", picName='" + picName + '\'' +
                ", picType='" + picType + '\'' +
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

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
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


}

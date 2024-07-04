package com.jebcdev.apirest.Controllers;

import com.jebcdev.apirest.Entities.Product;
import com.jebcdev.apirest.Repositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductRespository productRespository;

    @CrossOrigin
    @GetMapping
    public List<Product> getAllProducts() {
        return productRespository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRespository.findById(id)
                .orElseThrow(()->new RuntimeException("Product With Id: "+id+" Not Found!"));
    }

    @CrossOrigin
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return  productRespository.save(product);
    }

    @CrossOrigin
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails){

        Product product= productRespository.findById(id)
                .orElseThrow(()->new RuntimeException("Product With Id: "+id+" Not Found!"));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());

        return productRespository.save(product);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product product= productRespository.findById(id)
                .orElseThrow(()->new RuntimeException("Product With Id: "+id+" Not Found!"));

        productRespository.delete(product);

        return "Product With Id: "+id+" Deleted!";
    }
}

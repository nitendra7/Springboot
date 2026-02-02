package com.example.day4pms.controller;

import com.example.day4pms.model.ProductModel;
import com.example.day4pms.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String home(){
        return "Welcome";
    }
    @PostMapping("/add")
    public ProductModel addProduct(@Valid @RequestBody ProductModel product) {
        return service.add(product);
    }

    @GetMapping("/products")
    public List<ProductModel> getAllProducts() {
        return service.getAll();
    }

    @PutMapping("/products/{id}")
    public ProductModel updateProduct(@PathVariable String id, @RequestBody ProductModel product) {
        return service.update(id, product);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable String id) {
        return service.delete(id);
    }
}

package com.example.day4pms.service;

import com.example.day4pms.model.ProductModel;
import com.example.day4pms.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductModel add(ProductModel product) {
        return repo.save(product);
    }

    public List<ProductModel> getAll() {
        return repo.findAll();
    }

    public ProductModel update(String id, ProductModel product) {
        product.setId(id);
        return repo.save(product);
    }

    public String delete(String id) {
        repo.deleteById(id);
        return "Product deleted successfully.";
    }
}

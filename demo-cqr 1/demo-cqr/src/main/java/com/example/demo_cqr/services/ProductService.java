package com.example.demo_cqr.services;

import com.example.demo_cqr.model.Product;
import com.example.demo_cqr.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
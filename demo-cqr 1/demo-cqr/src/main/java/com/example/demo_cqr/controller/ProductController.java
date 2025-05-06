package com.example.demo_cqr.controller;

import com.example.demo_cqr.model.Product;
import com.example.demo_cqr.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @GetMapping("/product/{id}")
    public Product findById(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            productService.save(product);
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        try {
            Product currentProduct = productService.findById(id);
            currentProduct.setNombre(product.getNombre());
            currentProduct.setPrecio(product.getPrecio());
            productService.save(currentProduct);
            return new ResponseEntity<>(currentProduct, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        try {
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }


}
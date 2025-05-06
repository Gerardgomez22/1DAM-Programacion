package com.example.demo_cqr.controller;

import com.example.demo_cqr.dto.ProductCreateDTO;
import com.example.demo_cqr.dto.ProductDTO;
import com.example.demo_cqr.model.Category;
import com.example.demo_cqr.model.Product;
import com.example.demo_cqr.services.CategoryService;
import com.example.demo_cqr.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductCreateDTO dto) {
        Product p = new Product();
        p.setNombre(dto.getName());
        p.setPrice(dto.getPrice());
        p.setStock(dto.getStock());
        p.setPriceFabrication(dto.getPriceFabrication());

        if (dto.getCategoryId() != null) {
            Category c = categoryService.getCategory(dto.getCategoryId());
            p.setCategory(c);
        }

        Product savedProduct = productService.save(p);
        ProductDTO answer = transformToProductDTO(savedProduct);
        return new ResponseEntity<>(answer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> listProducts() {
        List<Product> products = productService.listProducts();
        List<ProductDTO> listaDTO = new ArrayList<>();
        for (Product p : products) {
            listaDTO.add(transformToProductDTO(p));
        }
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        Product p = productService.findById(id);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        ProductDTO dto = transformToProductDTO(p);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductCreateDTO dto) {
        Product existent = productService.findById(id);
        if (existent == null) {
            return ResponseEntity.notFound().build();
        }

        existent.setNombre(dto.getName());
        existent.setPrice(dto.getPrice());
        existent.setStock(dto.getStock());
        existent.setPriceFabrication(dto.getPriceFabrication());

        if (dto.getCategoryId() != null) {
            Category c = categoryService.getCategory(dto.getCategoryId());
            existent.setCategory(c);
        } else {
            existent.setCategory(null);
        }

        Product updated = productService.save(existent);
        ProductDTO answer = transformToProductDTO(updated);
        return ResponseEntity.ok(answer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private ProductDTO transformToProductDTO(Product p) {
        ProductDTO dto = new ProductDTO();
        dto.setId(p.getId());
        dto.setName(p.getNombre());
        dto.setPrice(p.getPrice());
        if (p.getCategory() != null) {
            dto.setCategoryName(p.getCategory().getName());
        }
        return dto;
    }
}
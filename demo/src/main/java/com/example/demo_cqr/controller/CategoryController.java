
package com.example.demo_cqr.controller;

import com.example.demo_cqr.dto.CategoryDTO;
import com.example.demo_cqr.model.Category;
import com.example.demo_cqr.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto) {
        // DTO -> Entidad
        Category c = new Category();
        c.setName(dto.getName());
        c.setDescription(dto.getDescription());

        Category savedCategory = categoryService.save(c);

        // Entidad -> DTO
        CategoryDTO response = transformToCategoryDTO(savedCategory);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> listCategories() {
        List<Category> list = categoryService.categoryList();
        List<CategoryDTO> dtos = new ArrayList<>();

        for (Category c : list) {
            dtos.add(transformToCategoryDTO(c));
        }

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
        Category c = categoryService.getCategory(id);
        if (c == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transformToCategoryDTO(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO dto) {
        Category c = categoryService.getCategory(id);
        if (c == null) {
            return ResponseEntity.notFound().build();
        }

        c.setName(dto.getName());
        c.setDescription(dto.getDescription());

        Category updatedCategory = categoryService.save(c);
        return ResponseEntity.ok(transformToCategoryDTO(updatedCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Convertir Entidad -> DTO
    private CategoryDTO transformToCategoryDTO(Category c) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setDescription(c.getDescription());
        return dto;
    }
}
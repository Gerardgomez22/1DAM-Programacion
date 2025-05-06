package com.example.demo_cqr.repository;

import com.example.demo_cqr.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

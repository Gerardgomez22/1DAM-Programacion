package com.example.demo_cqr.repository;
import com.example.demo_cqr.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}

package com.example.demo_cqr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "producto")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double price;
    private Integer stock;
    private Double priceFabrication;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
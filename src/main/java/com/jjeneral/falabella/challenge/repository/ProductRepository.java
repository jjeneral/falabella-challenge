package com.jjeneral.falabella.challenge.repository;

import com.jjeneral.falabella.challenge.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findFirstBySku(String sku);
}
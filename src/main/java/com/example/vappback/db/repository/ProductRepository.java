package com.example.vappback.db.repository;

import com.example.vappback.db.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}

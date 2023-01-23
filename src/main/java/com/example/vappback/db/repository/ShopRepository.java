package com.example.vappback.db.repository;

import com.example.vappback.db.entity.Shop;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {
    public List<Shop> findAll();
}

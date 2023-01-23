package com.example.vappback.db.repository;

import com.example.vappback.db.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

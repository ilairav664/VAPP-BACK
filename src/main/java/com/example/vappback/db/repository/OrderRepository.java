package com.example.vappback.db.repository;

import com.example.vappback.db.entity.Order;
import java.sql.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> getAllByOrderDateAfterAndOrderDateBeforeAndAndUserId(Date periodStart, Date periodEnd, Integer userId);
}

package com.example.vappback.controller;

import com.example.vappback.db.entity.Order;
import com.example.vappback.db.entity.Product;
import com.example.vappback.db.entity.User;
import com.example.vappback.db.repository.OrderRepository;
import com.example.vappback.db.repository.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {

    UserRepository userRepository;
    OrderRepository orderRepository;

    @Autowired
    public ReportController(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }



    @GetMapping("/users")
    public List<User> users() {
        List<User> result = new ArrayList<User>();
        userRepository.findAll().forEach(result::add);
        return result;
    }

    @GetMapping("/user/report")
    public int report(
            @RequestParam(value="userId") Integer userId,
            @RequestParam("start") @DateTimeFormat(pattern = "dd.MM.yyyy") Date start,
            @RequestParam("end") @DateTimeFormat(pattern = "dd.MM.yyyy") Date end
            ) {
        java.sql.Date startDate = new java.sql.Date(start.getTime());
        java.sql.Date endDate = new java.sql.Date(end.getTime());
        List <Order> orders =  orderRepository.getAllByOrderDateAfterAndOrderDateBeforeAndAndUserId(startDate,endDate, userId);
        return orders.stream().mapToInt(order -> order.getProducts().stream().mapToInt(Product::getBablos).sum()).sum();
    }
}

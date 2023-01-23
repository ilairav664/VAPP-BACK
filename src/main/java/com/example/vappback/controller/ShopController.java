package com.example.vappback.controller;

import com.example.vappback.db.entity.Account;
import com.example.vappback.db.entity.Order;
import com.example.vappback.db.entity.Product;
import com.example.vappback.db.entity.Shop;
import com.example.vappback.db.repository.AccountRepository;
import com.example.vappback.db.repository.OrderRepository;
import com.example.vappback.db.repository.ProductRepository;
import com.example.vappback.db.repository.ShopRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {
    ShopRepository shopRepository;
    AccountRepository accountRepository;
    ProductRepository productRepository;
    OrderRepository orderRepository;

    @Autowired
    public ShopController(ShopRepository shopRepository, AccountRepository accountRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.accountRepository = accountRepository;
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping(value = "/shops", produces={"application/json; charset=UTF-8"} )
    public List<Shop> getShops() {
        return shopRepository.findAll();
    }

    @PostMapping
    public Integer createOrder(@RequestParam(value="accountId") Integer accountId,
            @RequestParam(value="productId") Integer productId) {
            List<Product> products = new ArrayList<>();
            Product current = productRepository.findById(productId).get();
            products.add(current);

        Account chargeAccount = accountRepository.findAccountByAccountId(accountId);
        if (current.getCost() < chargeAccount.getBalance()) {
            chargeAccount.setBalance(chargeAccount.getBalance() - current.getCost());
            accountRepository.save(chargeAccount);
            Order order = new Order();
            order.setProducts(products);
            order.setSumm(current.getCost());
            order.setOrderDate(new Timestamp(System.currentTimeMillis()));
            order.setUserId(chargeAccount.getAccountHolder().getUserId());
            orderRepository.save(order);
            return 200;
        } else return 0;
    }

    @PostMapping(value = "/update/product", produces={"application/json; charset=UTF-8"} )
    public Boolean updateProduct(@RequestParam(value="productId") Integer productId,
            @RequestParam(value="bablos") Integer bablos) {
        Product product = productRepository.findById(productId).get();
        product.setBablos(bablos);
        productRepository.save(product);
        return true;
    }

}

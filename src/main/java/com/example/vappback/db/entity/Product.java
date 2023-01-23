package com.example.vappback.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products", schema = "s243140")
public class Product {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @Getter
    @Setter
    String name;
    @Getter
    @Setter
    String description;
    @Getter
    @Setter
    String imageUrl;
    @Getter
    @Setter
    Integer cost;
    @Getter
    @Setter
    Integer bablos;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="shop_id", nullable=false)
    Shop shop;

    @JsonIgnore
    @Getter
    @Setter
    @ManyToMany(mappedBy = "products")
    List<Order> orders;
}

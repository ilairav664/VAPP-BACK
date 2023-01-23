package com.example.vappback.db.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shop", schema = "s243140")
public class Shop {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shopId;
    @Getter
    @Setter
    String name;
    @Getter
    @Setter
    String address;
    @Getter
    @Setter
    @OneToMany(mappedBy = "shop")
    List<Product> products;
}

package com.example.vappback.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts", schema = "s243140")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    private String accountName;
    private Integer balance;
    private String cardNumber;
    private Boolean isMain;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id", nullable=false)
    private User accountHolder;

}

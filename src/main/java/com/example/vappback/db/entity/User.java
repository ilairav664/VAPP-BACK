package com.example.vappback.db.entity;


import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "users", schema = "s243140")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer userId;

    @Getter
    @Setter
    @Column
    private String name;

    @Getter
    @Setter
    @Column
    private String email;

    @Getter
    @Setter
    @Column
    private String image;


//    @OneToMany(mappedBy = "accountHolder", fetch = FetchType.LAZY)
//    private Collection <Account> userAccounts;

}
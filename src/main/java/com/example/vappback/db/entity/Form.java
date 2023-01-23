package com.example.vappback.db.entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "form",schema = "s243140")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer formId;
    private Integer userId;
    private Date date;
    @OneToMany(mappedBy = "form", cascade= CascadeType.ALL)
    private List<Answer> answers;
}

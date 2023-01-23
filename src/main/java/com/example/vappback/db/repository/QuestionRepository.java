package com.example.vappback.db.repository;

import com.example.vappback.db.entity.Question;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
    List<Question> getQuestionByType(Boolean type);
}

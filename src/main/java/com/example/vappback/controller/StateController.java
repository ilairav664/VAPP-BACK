package com.example.vappback.controller;

import com.example.vappback.db.entity.Form;
import com.example.vappback.db.entity.Question;
import com.example.vappback.db.repository.FormRepository;
import com.example.vappback.db.repository.QuestionRepository;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/state")
public class StateController {
    QuestionRepository questionRepository;
    FormRepository formRepository;

    @Autowired
    public StateController(QuestionRepository questionRepository, FormRepository formRepository) {
        this.questionRepository = questionRepository;
        this.formRepository = formRepository;
    }

    @RequestMapping(value = "/questions", method= RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    public List<Question> getQuestions() {
        List<Question> result = new ArrayList<>();
        questionRepository.findAll().forEach(result::add);
        return result;
    }

    @PostMapping(value = "/answers")
    public Integer saveAnswers(@RequestBody Form form) {
        form.setDate(new Date(System.currentTimeMillis()));
        form.getAnswers().forEach(answer -> answer.setForm(form));
        this.formRepository.save(form);
        return 200;
    }
}

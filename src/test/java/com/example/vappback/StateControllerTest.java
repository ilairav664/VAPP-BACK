package com.example.vappback;

import com.example.vappback.db.entity.Question;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StateControllerTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    Gson g = new Gson();

    @Test
    public void getQuestions() throws Exception {

        Type type = new TypeToken<ArrayList<Question>>() {}.getType();
        List<Question> questions = g.fromJson(this.restTemplate.getForObject("http://localhost:" + port + "/" + "state/questions", String.class), type);
        assertThat(!questions.isEmpty());
    }
}
package com.example.vappback;

import com.example.vappback.db.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ReportControllerTest {

	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	Gson g = new Gson();

	@Test
	public void getUsers() throws Exception {

		Type type = new TypeToken<ArrayList<User>>() {}.getType();
		List<User> users = g.fromJson(this.restTemplate.getForObject("http://localhost:" + port + "/" + "reports/users", String.class), type);
		assertThat(!users.isEmpty());
	}

	@Test
	public void getReport() throws Exception {

		String result = this.restTemplate.getForObject("http://localhost:" + port + "/" + "reports/user/report/?userId=0&&start=01.12.2022&&end=30.12.2022", String.class);
		assertThat(result.equals("0"));
	}
}
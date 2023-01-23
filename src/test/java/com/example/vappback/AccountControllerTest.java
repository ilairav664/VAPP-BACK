package com.example.vappback;

import com.example.vappback.db.entity.Account;
import com.example.vappback.db.entity.Shop;
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
public class AccountControllerTest {

	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	Gson g = new Gson();

	@Test
	public void addMoney() throws Exception {
		Map <String, String> params = new HashMap<>();
		params.put("accountId", "0");
		params.put("cardNumber", "1234123412341234");
		params.put("amount", "200");
		String result =this.restTemplate.postForObject("http://localhost:" + port + "/" + "account/addMoney",null, String.class);
		assertThat(result.equals("200"));;
	}

	@Test
	public void transferMoney() throws Exception {
		Map <String, String> params = new HashMap<>();
		params.put("accountId", "0");
		params.put("cardNumber", "1234123412341234");
		params.put("amount", "200");
		String result =this.restTemplate.postForObject("http://localhost:" + port + "/" + "account/transferMoney", null, String.class);
		assertThat(result.equals("200"));;
	}

	@Test
	public void getAccounts() throws Exception {

		Type type = new TypeToken<ArrayList<Account>>() {}.getType();
		List<Account> accounts = g.fromJson(this.restTemplate.getForObject("http://localhost:" + port + "/" + "account/?userId=0", String.class), type);
		assertThat(!accounts.isEmpty());
	}
}
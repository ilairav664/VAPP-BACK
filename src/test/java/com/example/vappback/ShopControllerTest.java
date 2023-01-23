package com.example.vappback;

import com.example.vappback.db.entity.Shop;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShopControllerTest {

	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	Gson g = new Gson();

	@Test
	public void getShops() throws Exception {
		Type type = new TypeToken<ArrayList<Shop>>() {}.getType();
		List<Shop> shops = g.fromJson(this.restTemplate.getForObject("http://localhost:" + port + "/" + "shop/shops", String.class), type);
		assertThat(!shops.isEmpty());
	}

	@Test
	public void createOrder() throws Exception {
		Map <String, String> params = new HashMap<>();
		params.put("accountId", "0");
		params.put("productId", "0");
		String result= this.restTemplate.postForObject("http://localhost:" + port + "/" + "shop/",null, String.class, params);
		assertThat(result.equals("200"));
	}

	@Test
	public void updateProduct() throws Exception {
		Map <String, String> params = new HashMap<>();
		params.put("productId", "0");
		params.put("bablosId", "999999");
		String result= this.restTemplate.postForObject("http://localhost:" + port + "/" + "shop/update/product",null, String.class, params);
		assertThat(result.equals("true"));
	}
}
package com.example.vappback;

import com.example.vappback.controller.AccountController;
import com.example.vappback.controller.ReportController;
import com.example.vappback.controller.ShopController;
import com.example.vappback.controller.StateController;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private ShopController shopController;

	@Autowired
	private AccountController accountController;

	@Autowired
	private StateController stateController;

	@Autowired
	private ReportController reportController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(shopController).isNotNull();
		assertThat(accountController).isNotNull();
		assertThat(stateController).isNotNull();
		assertThat(reportController).isNotNull();
	}
}
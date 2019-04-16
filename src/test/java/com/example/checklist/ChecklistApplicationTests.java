package com.example.checklist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.checklist.web.ChecklistController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChecklistApplicationTests {
	
	@Autowired
	private ChecklistController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}

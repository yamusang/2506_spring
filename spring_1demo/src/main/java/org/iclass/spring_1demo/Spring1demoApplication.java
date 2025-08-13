package org.iclass.spring_1demo;

import org.iclass.spring_1demo.old.DemoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Spring1demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring1demoApplication.class, args);
		DemoController controller = new DemoController();
		log.info("Application - main controller : {}", controller.getClass().toString());
	}

}

package com.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AgentOnBoardApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AgentOnBoardApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.sources(AgentOnBoardApplication.class);
		return super.configure(builder);
	}
}

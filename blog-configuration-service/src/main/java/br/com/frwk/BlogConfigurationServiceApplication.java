package br.com.frwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BlogConfigurationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogConfigurationServiceApplication.class, args);
	}

}

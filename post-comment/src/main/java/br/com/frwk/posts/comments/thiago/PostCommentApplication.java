package br.com.frwk.posts.comments.thiago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PostCommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostCommentApplication.class, args);
	}

}

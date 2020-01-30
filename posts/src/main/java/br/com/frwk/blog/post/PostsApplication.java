package br.com.frwk.blog.post;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class PostsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostsApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
	}

}

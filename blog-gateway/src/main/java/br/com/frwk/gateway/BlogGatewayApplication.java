package br.com.frwk.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import br.com.frwk.gateway.filter.AuthenticatedFilter;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class BlogGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogGatewayApplication.class, args);
	}
	
	@Bean
	public AuthenticatedFilter addAuthenticatedFilter() {
		return new AuthenticatedFilter();
	}

}

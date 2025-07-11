package com.fdmgroup.AccountAndCustomerManagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.AccountAndCustomerManagement.service.GeoCoderService;


@SpringBootApplication
public class AccountAndCustomerManagementApplication implements CommandLineRunner {

	private final String GEOCODER_BASE_URL= "https://geocoder.ca";
	
	ApplicationContext ctx;
	
	public AccountAndCustomerManagementApplication(ApplicationContext ctx) {
		super();
		this.ctx = ctx;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountAndCustomerManagementApplication.class, args);
	}
	
	@Bean
	public WebClient.Builder webClientBuilder()
	{
		return WebClient.builder();
	}
	
	
	@Bean
	public WebClient geocoderWebClient(WebClient.Builder builder)
	{
		return builder.baseUrl(GEOCODER_BASE_URL)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Application is Up and Running");
//		System.out.println("DTO received: " + customerDTO);
//	    GeoCoderService geocoderService = ctx.getBean(GeoCoderService.class);
//		
//	    System.out.println("printing all the posts");
//	    System.out.println(geocoderService.getLocationByPostalCode("M5V3L9"));	
	}

}

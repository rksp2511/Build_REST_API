package com.amex.hotelbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
public class HotelBookingApplication {

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).groupName("hotel-booking").select()
				.apis(RequestHandlerSelectors.basePackage("com.amex.hotelbooking"))
				.paths(any()).build().apiInfo(new ApiInfo("Hotel Booking Services",
						"A set of services to do hotel room booking", "1.0.0", null,
						new Contact("Nagaraja Settra", "https://twitter.com/developer", null),null, null));
	}
	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
	}

}

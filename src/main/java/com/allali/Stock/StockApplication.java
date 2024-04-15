package com.allali.Stock;

import com.allali.Stock.service.Initiation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}
	@Bean
	CommandLineRunner start(Initiation initiation){
		return args -> {
			initiation.initCategory();
			initiation.initFournisseur();
			initiation.initClient();
			initiation.initArticle();
			//initiation.initTransition();
			//initiation.initTransition2();
		};
	}
}

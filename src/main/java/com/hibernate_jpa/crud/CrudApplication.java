package com.hibernate_jpa.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {SpringApplication.run(CrudApplication.class, args);}

		@Bean
		public CommandLineRunner commandLineRunner(String[] args) {
			return runner -> {
				System.out.println("Hello World");
			};
		}
}



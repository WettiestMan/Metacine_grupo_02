package com.grupo02.web;

//import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MetacineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetacineApplication.class, args);
	}

	/*private static <T> void qsort(T[] arr) {
		qsort(arr, 0, arr.length - 1);
	}

	private static <T> void qsort(T[] arr, int lo, int hi) {
		qsort(arr, 0, arr.length);
	}*/

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's go get some beans, yippie");

			String[] beans = ctx.getBeanDefinitionNames();
			Arrays.sort(beans);
			for(final var bean : beans){
				System.out.println(bean);
			}
		};
	}

}

package com.speaking.clock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpeakingClockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeakingClockApplication.class, args);
		System.out.println("You can hit this api it is get type api and provide time in 22:50 this format");
		System.out.println("http://localhost:8080/speaking?time=22:50");
	}

}

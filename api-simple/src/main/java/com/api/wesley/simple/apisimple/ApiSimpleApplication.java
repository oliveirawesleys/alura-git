package com.api.wesley.simple.apisimple;

import com.api.wesley.simple.apisimple.model.User;
import com.api.wesley.simple.apisimple.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class ApiSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSimpleApplication.class, args);
	}


	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			userRepository.deleteAll();
			LongStream.range(1,5)
					.mapToObj(i -> new User(i, "User " + i, " user" + i + "@email.com", "(11)3322-1212"))
					.map(v -> userRepository.save(v))
					.forEach(System.out::println);
		};
	}

}

package com.wesley.springhelloh2;

import com.wesley.springhelloh2.model.Contact;
import com.wesley.springhelloh2.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class SpringHelloH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringHelloH2Application.class, args);
	}

	@Bean
	CommandLineRunner init(ContactRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> new Contact(i, "Contact " + i, "contact" + i + "@email.com", " (11) 1111-1111"))
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}

}

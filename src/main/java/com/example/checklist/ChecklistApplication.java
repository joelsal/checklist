package com.example.checklist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.checklist.domain.User;
import com.example.checklist.domain.UserRepository;
import com.example.checklist.domain.Entry;
import com.example.checklist.domain.EntryRepository;
import com.example.checklist.domain.Importance;
import com.example.checklist.domain.ImportanceRepository;

@SpringBootApplication
public class ChecklistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChecklistApplication.class, args);
	}
	
	Importance importance1 = new Importance("Low");		//importance data is created
	Importance importance2 = new Importance("Moderate");
	Importance importance3 = new Importance("High");
	
	
	@Bean
	public CommandLineRunner demo(ImportanceRepository repository) {	//Importance data values are saved to the repository
		return (args) -> {
			repository.save(importance1);
			repository.save(importance2);
			repository.save(importance3);
		};
	}
	
	@Bean
	public CommandLineRunner testentry(EntryRepository repository) {				//Test data for tasks - (importance, entryName, entryText)
		return (args) -> {
			Entry entry1 = new Entry(importance1, "Kotitehtävät", "Muista tehdä enkun läksyt");
			Entry entry2 = new Entry(importance1, "Ruokaostokset", "Muista ostaa omenoita");
			Entry entry3 = new Entry(importance1, "Synttärit", "Muista Jaakon synttärit 10.6");
			
			repository.save(entry1);
			repository.save(entry2);
			repository.save(entry3);
		};
	}
	
	@Bean
	public CommandLineRunner demo2(UserRepository repository) {		//User data
		return (args) -> {
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			repository.save(user1);
			repository.save(user2);
		};
	}

}

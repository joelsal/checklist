package com.example.checklist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.checklist.domain.Entry;
import com.example.checklist.domain.EntryRepository;
import com.example.checklist.domain.Importance;
import com.example.checklist.domain.ImportanceRepository;

@SpringBootApplication
public class ChecklistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChecklistApplication.class, args);
	}
	
	Importance importance1 = new Importance("1");		//importance data is created
	Importance importance2 = new Importance("2");
	Importance importance3 = new Importance("3");
	
	
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

}

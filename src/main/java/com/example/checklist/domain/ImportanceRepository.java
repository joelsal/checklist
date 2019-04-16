package com.example.checklist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ImportanceRepository extends CrudRepository<Importance, Long> {
	List<Importance> findByImportanceState(String importanceState);
}

package br.com.elias.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elias.model.Task;

public interface ITaskRepository extends JpaRepository<Task, Long>{
	Page<Task> findByDescription(String description, Pageable pageable);
}  
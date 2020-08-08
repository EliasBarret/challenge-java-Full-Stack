package br.com.elias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elias.model.ListTask;

public interface IListTaskRepository extends JpaRepository<ListTask, Long> {

}

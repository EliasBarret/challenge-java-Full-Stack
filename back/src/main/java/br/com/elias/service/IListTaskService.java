package br.com.elias.service;



import java.util.List;

import br.com.elias.model.ListTask;
import br.com.elias.util.Response;


public interface IListTaskService {
	
	/**
	 * Method to save a ListTask
	 * 
	 * @param listTask
	 * @return listTask
	 */
	ListTask insert(ListTask listTask);

	/**
	 * Method to find a ListTask by Id
	 * 
	 * @param id
	 * @return
	 */
	ListTask findById(Long id);

	/**
	 * Method to find a ListTask all
	 * 
	 * @return
	 */
	List<ListTask> findAll();
}

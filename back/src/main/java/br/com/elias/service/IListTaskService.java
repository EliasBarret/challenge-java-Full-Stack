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
	 * Method to delete a List Task by Id
	 * 
	 * @param id
	 * @return Response
	 */
	Response deleteById(Long id);
	
	/**
	 * Method to alter text by ListTask
	 * 
	 * @param listTask
	 * @param id
	 * @return listTask
	 */
	ListTask alter(ListTask listTask, Long id);
	
	List<ListTask> findAll();
}

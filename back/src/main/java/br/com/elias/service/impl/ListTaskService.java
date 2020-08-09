package br.com.elias.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elias.exception.CustomException;
import br.com.elias.model.ListTask;
import br.com.elias.repository.IListTaskRepository;
import br.com.elias.service.IListTaskService;
import br.com.elias.util.Constants;
import br.com.elias.util.Response;

@Service
public class ListTaskService implements IListTaskService{
	
	@Autowired
	private IListTaskRepository iListTaskRepository;
	
	@Override
	public ListTask insert(ListTask listTask) {
       return iListTaskRepository.save(listTask);

	}
	@Override
	public ListTask findById(Long id) {
		Optional<ListTask> listTask = iListTaskRepository.findById(id);

        if(listTask.isPresent()){
            return listTask.get();
        }else{
            throw new CustomException(Constants.LISTTASK_NOT_FOUND);
        }
	}

	@Override
	public Response deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListTask alter(ListTask listTask, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ListTask> findAll() {
		
		return iListTaskRepository.findAll();
	}
	
	
	
}

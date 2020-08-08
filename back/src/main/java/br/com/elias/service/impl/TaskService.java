package br.com.elias.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.elias.exception.CustomException;
import br.com.elias.model.ListTask;
import br.com.elias.model.Task;
import br.com.elias.repository.IListTaskRepository;
import br.com.elias.repository.ITaskRepository;
import br.com.elias.service.ITaskService;
import br.com.elias.util.Constants;
import br.com.elias.util.Response;

@Service
public class TaskService implements ITaskService{

	@Autowired
	private ITaskRepository iTaskRepository;
	
	@Autowired
	private IListTaskRepository iListTaskRepository;
	
	@Override
	public Task insert(Task task) {
		
		if(task.getListTask().getId() == null) {
			throw new CustomException(Constants.ID_REQUIRED);
		}
		
		Optional<ListTask> listTask = iListTaskRepository.findById(task.getListTask().getId());
	
		if(listTask.isPresent()) {		
			return iTaskRepository.save(task);
		}else{
			 throw new CustomException(Constants.ID_LISTTASK_REQUIRED);
		}

	}

	@Override
	public Task alter(Task task, Long id) {
		 Optional<Task> tsk = iTaskRepository.findById(id);
	        if(tsk.isPresent()){
	        	tsk.get().setDescription(task.getDescription());
	            return iTaskRepository.save(tsk.get());
	        }else{
	            throw new CustomException(Constants.TASK_NOT_FOUND);
	        }
	}

	@Override
	public Page<Task> findByDescription(String description, Pageable pageable) {
		return iTaskRepository.findByDescription(description, pageable);
	}

	@Override
	public Task findById(Long id) {
		Optional<Task> task = iTaskRepository.findById(id);

        if(task.isPresent()){
            return task.get();
        }else{
            throw new CustomException(Constants.TASK_NOT_FOUND);
        }
	}

	@Override
	public Response deleteById(Long id) {
		Optional<Task> task = iTaskRepository.findById(id);

        if(task.isPresent()){
        	iTaskRepository.deleteById(id);
            return new Response(Constants.SUCESS, Constants.DELETED_SUCCESSFUL);
        }else{
            throw new CustomException(Constants.TASK_NOT_FOUND);
        }
	}
	
}

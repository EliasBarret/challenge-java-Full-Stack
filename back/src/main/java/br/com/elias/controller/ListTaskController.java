package br.com.elias.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.elias.model.ListTask;
import br.com.elias.model.dto.ListTaskDTO;
import br.com.elias.service.IListTaskService;
import br.com.elias.util.Response;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/listTask")
public class ListTaskController {
	@Autowired
	private IListTaskService iListTaskService;

	@PostMapping
	public ResponseEntity<ListTask> insert(@RequestBody @Valid ListTaskDTO listTaskDTO) {
		ListTask listTask = new ModelMapper().map(listTaskDTO, ListTask.class);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(iListTaskService.insert(listTask).getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<ListTask> findById(@PathVariable Long id){
        return new ResponseEntity<>(iListTaskService.findById(id), HttpStatus.OK);
    }
    
    @GetMapping("/")
    public List<ListTask> findAll(){
    	return iListTaskService.findAll();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        return new ResponseEntity<>(iListTaskService.deleteById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListTask> alter(@RequestBody @Valid ListTaskDTO listTaskDTO, @PathVariable Long id){
        ListTask listTask = new ModelMapper().map(listTaskDTO, ListTask.class);
        return new ResponseEntity<>(iListTaskService.alter(listTask, id), HttpStatus.OK);
    }
    
}


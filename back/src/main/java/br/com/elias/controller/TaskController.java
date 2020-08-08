package br.com.elias.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.elias.model.Task;
import br.com.elias.model.dto.TaskDTO;
import br.com.elias.service.ITaskService;
import br.com.elias.util.Response;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private ITaskService iTaskService;
	
    @PostMapping
    public ResponseEntity<Task> insert(@RequestBody @Valid TaskDTO taskDTO){
        Task task = new ModelMapper().map(taskDTO, Task.class);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(iTaskService.insert(task).getId()).toUri();
        return ResponseEntity.created(location).build();
    }
	
    @GetMapping("/name/{name}")
    public ResponseEntity<Page<Task>> findByName(@PathVariable String description, Pageable pageable){
        return new ResponseEntity<>(iTaskService.findByDescription(description, pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id){
        return new ResponseEntity<>(iTaskService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        return new ResponseEntity<>(iTaskService.deleteById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> alter(@RequestBody @Valid TaskDTO taskDTO, @PathVariable Long id){
        Task task = new ModelMapper().map(taskDTO, Task.class);
        return new ResponseEntity<>(iTaskService.alter(task, id), HttpStatus.OK);
    }
}

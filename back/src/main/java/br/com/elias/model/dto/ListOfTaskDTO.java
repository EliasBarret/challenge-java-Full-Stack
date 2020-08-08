package br.com.elias.model.dto;

import java.util.List;

import br.com.elias.model.Task;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ListOfTaskDTO {
	
	private Long id;
    
    private String description;
    
    private String sn_done;
    
    private List<Task> listTasks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSn_done() {
		return sn_done;
	}

	public void setSn_done(String sn_done) {
		this.sn_done = sn_done;
	}

	public List<Task> getListTasks() {
		return listTasks;
	}

	public void setListTasks(List<Task> listTasks) {
		this.listTasks = listTasks;
	}
}

package br.com.elias.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    
	private String description;
    
    private ListOfTaskDTO list;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ListOfTaskDTO getList() {
		return list;
	}

	public void setList(ListOfTaskDTO list) {
		this.list = list;
	}
    
}

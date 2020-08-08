package br.com.elias.model.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import br.com.elias.model.Task;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class ListTaskDTO {
    @Column
    private String description;
    
    @Column
    private String sn_done;	
	
	private List<Task> listTasks;

	public List<Task> getListTasks() {
		return listTasks;
	}

	public void setListTasks(List<Task> listTasks) {
		this.listTasks = listTasks;
	}

	public String getSn_done() {
		return sn_done;
	}

	public void setSn_done(String sn_done) {
		this.sn_done = sn_done;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

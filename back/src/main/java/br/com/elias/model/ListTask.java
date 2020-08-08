package br.com.elias.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ListTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @Column
    private String description;
    
    @Column
    private String sn_done;
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<Task> listTasks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

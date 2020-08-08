package br.com.elias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table
@Entity 
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @Column(name = "name", length = 100, nullable = false)
	private String description;
    
    @OneToOne(fetch = FetchType.EAGER)
    private ListTask listTask;

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

	public ListTask getListTask() {
		return listTask;
	}

	public void setListTask(ListTask listTask) {
		this.listTask = listTask;
	}
    
    
    
}

package com.learning.springboot.toDoWebApp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "ToDo_SEQ", sequenceName = "ToDo_SEQ", allocationSize = 1)
public class ToDo {
	
	
	public ToDo() {
		
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ToDo_SEQ")
	private int id;
	
	private String username;
	
	@Size(min=10, message = "Enter at least 10 characters")
	private String description;
	
	private LocalDate date;
	
	private boolean done;
	
	public ToDo( String username, String description, LocalDate date, boolean done) {
		super();
		
		this.username = username;
		this.description = description;
		this.date = date;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "ToDo [ username=" + username + ", description=" + description + ", date=" + date
				+ ", done=" + done + "]";
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}

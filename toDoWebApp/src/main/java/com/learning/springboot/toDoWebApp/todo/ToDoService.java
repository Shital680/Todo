package com.learning.springboot.toDoWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

//@Service
public class ToDoService {
	private static List<ToDo> todos = new ArrayList<>();
	private static int todoCount=0;
	static {
		todos.add(new ToDo("Shital","AWS", LocalDate.now().plusYears(1),false));
		todos.add(new ToDo("Raj","Azure", LocalDate.now().plusYears(2),false));
		todos.add(new ToDo("Shital","SpringBoot", LocalDate.now().plusYears(3),false));
		todos.add(new ToDo("Ram","SpringBoot", LocalDate.now().plusYears(3),false));
		todos.add(new ToDo("Raj","SpringBoot", LocalDate.now().plusYears(3),false));
		todos.add(new ToDo("Shital","SpringBoot", LocalDate.now().plusYears(3),false));
	}
	
	public List<ToDo> findByUser(String username){
		Predicate<? super ToDo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username,String description, LocalDate TargetDate, boolean done) {
		ToDo todo=new ToDo(username,description,TargetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId()==id;
		todos.removeIf(predicate );
	}
	
	public ToDo findById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId()==id;
		ToDo todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid ToDo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}

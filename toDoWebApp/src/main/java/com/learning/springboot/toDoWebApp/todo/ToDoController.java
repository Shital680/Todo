
package com.learning.springboot.toDoWebApp.todo;


import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class ToDoController {
	private ToDoService todoService;
	
	
	public ToDoController(ToDoService todoService) {
		super();
		this.todoService = todoService;
	}


	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username=getLoggedInUser();
		List<ToDo> todos = todoService.findByUser(username);
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodo(ModelMap model) {
		String username=getLoggedInUser();
		ToDo todo=new ToDo(username,"",LocalDate.now(),false);
		model.put("todo", todo);
		return "todo";
	}


	
	
	private String getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		return authentication.getName();
		 
	}


//	@RequestMapping(value="add-todo", method=RequestMethod.POST)
//	public String addNewTodo(@RequestParam String description,@RequestParam String username,@RequestParam LocalDate date,@RequestParam boolean done, ModelMap model) {
//		 // username=(String)model.get("username");
//		todoService.addTodo(username, description, date, done);
//		return "redirect:list-todos";
//	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid @ModelAttribute("todo") ToDo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		//String username=(String)model.get("username");
		todoService.addTodo(todo.getUsername(), todo.getDescription(),todo.getDate(),todo.isDone());
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, /*@ModelAttribute("todo") ToDo todo*/ ModelMap model) {
		ToDo todo=todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid @ModelAttribute("todo") ToDo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		//String username=(String)model.get("username");
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}

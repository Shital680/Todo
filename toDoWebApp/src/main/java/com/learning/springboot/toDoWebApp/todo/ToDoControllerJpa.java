
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

@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {
	
	
	private ToDoRepository todoRepository;
	
	public ToDoControllerJpa(ToDoRepository todoRepository) {
		super();
		this.todoRepository =todoRepository;
	}


	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username=getLoggedInUser(model);
		List<ToDo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodo(ModelMap model) {
		String username=getLoggedInUser(model);
		ToDo todo=new ToDo( username,"",LocalDate.now(),true);
		model.put("todo", todo);
		return "todo";
	
	}

	
	
	private String getLoggedInUser(ModelMap model) {
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
	public String addNewTodo(ModelMap model,@Valid ToDo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		//String username=(String)model.get("username");
		String username = getLoggedInUser(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	



	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//todoService.deleteById(id);
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		
		ToDo todo=todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid ToDo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		//String username=(String)model.get("username");
		String username = getLoggedInUser(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		
		return "redirect:list-todos";
	}
}

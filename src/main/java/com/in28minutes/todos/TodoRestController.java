package com.in28minutes.todos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/todos")
	public List<Todo> getTodos() {
		return todoService.retrieveTodos("Zalman");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/todos/{id}")
	public Todo getTodoById(@PathVariable("id") int id) {
		return todoService.retrieveTodo(id);
	}
	
}
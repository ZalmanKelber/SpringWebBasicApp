package com.in28minutes.todos;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String getTodos(ModelMap model) {
		model.addAttribute("todos", todoService.retrieveTodos("Zalman"));
		return "list-todos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap model) {
		model.addAttribute("todo", new Todo(0, "Zalman", "Task description", new Date(), false));
		return "add-todo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodo(ModelMap model, @RequestParam int id) {
		model.addAttribute("todo", todoService.retrieveTodo(id));
		return "add-todo";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String handleAddTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "add-todo";
		}
		model.clear();
		todoService.addTodo("Zalman", todo.getDesc(), new Date(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String handleUpdateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "add-todo";
		}
		model.clear();
		todo.setUser("Zalman");
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		model.clear();
		todoService.deleteTodo(id);
		return "redirect:list-todos";
	}
	

}
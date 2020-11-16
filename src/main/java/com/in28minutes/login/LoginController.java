package com.in28minutes.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in28minutes.todos.TodoService;

@Controller
public class LoginController {
	
	@Autowired
	TodoService todoService;
	
	@Autowired
	UserValidationService userValidationService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginRedirect() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitLogin(@RequestParam String name, 
			@RequestParam String password,
			ModelMap model) {
		if (userValidationService.isValid(name, password)) {
			model.addAttribute("todos", todoService.retrieveTodos(name));
			return "list-todos";
//			model.put("name", name);
//			model.put("password", password);
//			return "landing";
		}
		model.put("errorMessage", "Invalid Credentials");
		return "login";
	}

}

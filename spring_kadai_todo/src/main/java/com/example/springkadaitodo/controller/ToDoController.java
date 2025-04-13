package com.example.springkadaitodo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {
	
	private final ToDoService todoService;
	//コンストラクタインジェクション
	public ToDoController(ToDoService todoService) {
		this.todoService = todoService;
	}
 

    @GetMapping("/todo")
    public String showTodoList(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "todoView";
    }
}

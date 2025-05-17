package com.app.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.todoapp.models.Task;
import com.app.todoapp.service.TaskService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
@RequestMapping("/task")
public class TaskController{

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getTask(Model model){
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/postTask")
    public String postTask(@RequestParam String taskTitle){
        taskService.postTask(taskTitle);
        return "redirect:/task/";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/task/";
    }

    @GetMapping("/toggleTask/{id}")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/task/";
    }
    
}
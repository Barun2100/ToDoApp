package com.app.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.todoapp.models.Task;
import com.app.todoapp.repository.TaskRepo;
import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public List<Task> getAllTask(){
        return taskRepo.findAll();
    }

    public void postTask(String taskTitle) {
        Task task = new Task();
        task.setTaskTitle(taskTitle);
        task.setTaskComplete(false);

        taskRepo.save(task);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid task id ... "));
        task.setTaskComplete(!task.isTaskComplete());
        taskRepo.save(task);
    }
    
}

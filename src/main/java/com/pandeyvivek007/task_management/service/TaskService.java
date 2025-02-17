package com.pandeyvivek007.task_management.service;

import com.pandeyvivek007.task_management.entity.Task;
import com.pandeyvivek007.task_management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {


    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<List<Task>> getAllTask(){
        List<Task> tasks = taskRepository.findAll();
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }


    public Task getById(long id){
        return taskRepository.findById(id);
    }

    public Task getTaskBeforeDate(Date date){
        return taskRepository.findTaskBeforeDate(date);
    }
}

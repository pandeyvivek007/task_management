package com.pandeyvivek007.task_management.controllers;

import com.pandeyvivek007.task_management.entity.Task;
import com.pandeyvivek007.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Controller
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        return taskService.getAllTask();
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Task task){
        return new ResponseEntity<Task>(taskService.createTask(task), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getAllTasks(@PathVariable long id){
        if(taskService.getById(id) != null){
            return new ResponseEntity<Task>(taskService.getById(id), HttpStatus.OK);
        }else return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<Task> getTaskBeforeDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        if(taskService.getTaskBeforeDate(date) !=null){
            return new ResponseEntity<>(taskService.getTaskBeforeDate(date), HttpStatus.OK);

        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

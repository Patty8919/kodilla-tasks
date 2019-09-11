package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTask());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask/{taskId}")
    public TaskDto getTask(@PathVariable("taskId") Long taskId) {
        return taskMapper.mapToTaskDto((service.getTaskById(taskId)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask/{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDto updateTask( TaskDto taskDto) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "saveTask")
    public void createTask( TaskDto taskDto) {

    }
}

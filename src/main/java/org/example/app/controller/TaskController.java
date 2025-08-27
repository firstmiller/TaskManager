package org.example.app.controller;

import lombok.AllArgsConstructor;
import org.example.app.dto.TaskDTO;
import org.example.app.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/user/{id}")
    public List<TaskDTO> getTasksByUserId(@PathVariable("id") long id) {
        return taskService.getTasksByUserId(id);
    }
}

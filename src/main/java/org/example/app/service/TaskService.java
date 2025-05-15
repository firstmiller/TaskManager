package org.example.app.service;

import org.example.app.dto.TaskDto;
import org.example.app.entity.Task;
import org.example.app.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDto> getTasksByListId(long id) {
        List<Task> tasks = taskRepository.getTasksByListId(id);
        return tasks.stream()
                .map(t -> new TaskDto(t.getTitle(), t.getDescription(), t.getCreatedAt()))
                .collect(Collectors.toList());
    }
    public List<TaskDto> getTasksByUserId(long id) {
        List<Task> tasks = taskRepository.getTasksByUserId(id);
        return tasks.stream()
                .map(t -> new TaskDto(t.getTitle(), t.getDescription(), t.getCreatedAt()))
                .collect(Collectors.toList());
    }
}

package org.example.app.service;

import org.example.app.dto.TaskDTO;
import org.example.app.entity.Task;
import org.example.app.mapper.TaskMapper;
import org.example.app.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskDTO> getTasksByListId(long id) {
        List<Task> tasks = taskRepository.getTasksByTaskList_Id(id);
        return tasks.stream()
                .map(t -> new TaskDTO(t.getId(), t.getTitle(), t.getDescription(), t.getCreatedAt()))
                .collect(Collectors.toList());
    }

    public List<TaskDTO> getTasksByUserId(long id) {
        return taskRepository.findByTaskList_Board_User_Id(id).stream()
                .map(taskMapper::toDTO)
                .collect(Collectors.toList());
    }

}

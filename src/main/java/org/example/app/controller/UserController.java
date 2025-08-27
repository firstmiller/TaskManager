package org.example.app.controller;

import org.example.app.dto.TaskDTO;
import org.example.app.dto.UserDTO;
import org.example.app.entity.User;
import org.example.app.service.TaskService;
import org.example.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        System.out.println("controller");
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") long id) {
        UserDTO user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<TaskDTO>> getAllTasksByUserId(@PathVariable("userId") long id) {
        List<TaskDTO> tasks = taskService.getTasksByUserId(id);

        if (tasks.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        UserDTO created = userService.register(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") long id) {
        userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.noContent().build();
    }
}

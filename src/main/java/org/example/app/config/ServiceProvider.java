package org.example.app.config;

import lombok.Getter;

import org.example.app.repository.impl.RoleRepositoryImpl;
import org.example.app.repository.impl.TaskRepositoryImpl;
import org.example.app.repository.impl.UserRepositoryImpl;
import org.example.app.service.RoleService;
import org.example.app.service.TaskService;
import org.example.app.service.UserService;

@Getter
public class ServiceProvider {
    private static final ServiceProvider INSTANCE = new ServiceProvider();

    public static ServiceProvider getInstance() {
        return INSTANCE;
    }

    private final UserService userService = new UserService(new UserRepositoryImpl());
    private final TaskService taskService = new TaskService(new TaskRepositoryImpl());
    private final RoleService roleService = new RoleService(new RoleRepositoryImpl());

    private ServiceProvider() {
    }

}

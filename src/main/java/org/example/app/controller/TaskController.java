package org.example.app.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.app.config.ServiceProvider;
import org.example.app.dto.TaskDto;
import org.example.app.service.TaskService;

import java.util.List;

@Path("tasks")
public class TaskController {
    private final TaskService taskService = ServiceProvider.getInstance().getTaskService();

    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaskDto> getTasksByUserId(@PathParam("id") long id) {
        return taskService.getTasksByUserId(id);
    }
}

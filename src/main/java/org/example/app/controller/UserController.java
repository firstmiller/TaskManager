package org.example.app.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.app.config.ServiceProvider;
import org.example.app.entity.User;
import org.example.app.service.UserService;

import java.util.List;

@Path("/users")
public class UserController {
    private final UserService userService = ServiceProvider.getInstance().getUserService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") long id) {
        return userService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User user) {
        userService.create(user);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserById(@PathParam("id") long id) {
        boolean isDeleted = userService.deleteById(id);

        if (!isDeleted)
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Пользователь с ID " + id + " не найден.")
                    .build();

        return Response.noContent().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user) {
        userService.update(user);
    }
}

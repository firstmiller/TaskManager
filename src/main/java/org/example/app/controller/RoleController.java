package org.example.app.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.app.config.ServiceProvider;
import org.example.app.entity.Role;
import org.example.app.service.RoleService;

import java.util.List;

@Path("/roles")
public class RoleController {
    private final RoleService roleService = ServiceProvider.getInstance().getRoleService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getAllRoles() {
        return roleService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Role getRoleById(@PathParam("id") long id) {
        return roleService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createRole(Role role) {
        roleService.create(role);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteRole(Role role) {
        roleService.delete(role);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateRole(Role role) {
        roleService.update(role);
    }
}
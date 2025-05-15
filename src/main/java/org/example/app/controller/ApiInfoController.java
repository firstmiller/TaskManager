package org.example.app.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class ApiInfoController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getApiInfo() {
        return Response.ok("REST API for Task Manager").build();
    }
}
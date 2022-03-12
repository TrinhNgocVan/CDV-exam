package com.aptech.t2004e.jax_ws.resource;

import com.aptech.t2004e.jax_ws.entity.Employee;
import com.aptech.t2004e.jax_ws.repository.ExamRepo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
@Path("/products")
public class ExamResource {

    private ExamRepo examRepo;

    public ExamResource() {
        this.examRepo = new ExamRepo();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            return Response.status(Response.Status.OK).entity(examRepo.findAll()).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.OK).entity(new ArrayList<>()).build();
        }
    }

    @GET()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        try {
            return Response.status(Response.Status.OK).entity(examRepo.findById(id)).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Employee product) {
        try {
            Employee savedProduct = examRepo.save(product);
            return Response.status(Response.Status.CREATED).entity(savedProduct).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT()
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Employee product) {
        try {
            Employee foundProduct = examRepo.findById(id);
            if (foundProduct == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            Employee updatedProduct = examRepo.update(id, product);
            return Response.status(Response.Status.OK).entity(updatedProduct).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            Employee foundProduct = examRepo.findById(id);
            if (foundProduct == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            boolean isDeleted = examRepo.delete(id);
            if (isDeleted) {
                return Response.status(Response.Status.OK).entity(isDeleted).build();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}

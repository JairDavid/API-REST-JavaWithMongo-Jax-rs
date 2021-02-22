package com.edu.utez.controller;

import com.edu.utez.entity.EntityCar;
import com.edu.utez.entity.EntityCarDao;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;
import java.util.List;

@Path("/cars")
public class EntityCarController {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EntityCar> carsList(){
        return new EntityCarDao().carsList();
    }

    @GET
    @Path("/unique/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String uniqueCar(@PathParam("id") String id){
        return new EntityCarDao().uniqueCar(id);
    }
    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean newCar(EntityCar entityCar){
        return new EntityCarDao().insertNew(entityCar);
    }
    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateCar(EntityCar entityCar, @PathParam("id") String id){
        return new EntityCarDao().update(entityCar,id);
    }
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteCar(@PathParam("id") String id){
        return new EntityCarDao().delete(id);
    }
}
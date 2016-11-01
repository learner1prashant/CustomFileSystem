package com.prashant;

import com.prashant.filesystem.EntityReference;
import com.prashant.filesystem.FileSystem;
import com.prashant.filesystem.factory.EntityType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.List;

@Path("fs")
public class FileSystemService {

    FileSystem fileSystem;

    public FileSystemService() {
        fileSystem = new FileSystem();
    }


    @GET
    @Path("/{pathName}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFileEntity(@PathParam("pathName") String pathName) {
        List<EntityReference> list = fileSystem.getEntitiesByPathName(pathName);
        return Response.ok(list, MediaType.APPLICATION_OCTET_STREAM).status(200)
                .header("Content-Disposition", "File entity list attached ").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFileEntities() {
        EntityReference rootRef = fileSystem.getFileEntities();
        return Response.ok(rootRef, MediaType.APPLICATION_OCTET_STREAM).status(200)
                .header("Content-Disposition", "File entity list attached ").build();

    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response createFileEntity(@QueryParam("pathName") String pathName, @QueryParam("entityName") String entityName, @QueryParam("entityName") EntityType entityType) {
        EntityReference file = fileSystem.createFileEntity(pathName,entityName, entityType);
        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM).status(200)
                .header("Content-Disposition", "File created ; filename=\"" + file.getName() + "\"" ).build();

    }

    @PUT
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response updateFileEntity(@QueryParam("pathName") String pathName, @QueryParam("entityName") String entityName) {
        EntityReference file = fileSystem.updateFileEntity(pathName,entityName);
        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM).status(200)
                .header("Content-Disposition", "File updated; filename=\"" + file.getName() + "\"" ).build();

    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteFileEntity(@QueryParam("pathName") String pathName, @QueryParam("entityName") String entityName) {
        fileSystem.removeEntity(pathName,entityName);
        return Response.ok(true, MediaType.TEXT_PLAIN).status(200)
                .header("Content-Disposition", "File Entity deleted" ).build();

    }


}

package services;

import model.Message;
import model.Task;
import providers.TaskProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("A00359221tasksManager")
public class TaskServices {

    @GET
    @Path("echo")
    public String echo (){
        return  " echo";
    }


    @POST
    @Path("create")
    @Consumes("application/json")
    public Response create(Task task){


        try {

            TaskProvider provider = new TaskProvider();
            provider.create(task);
            return Response
                    .ok(new Message("Operacion existosa"))
                    .header("Content-Type","application/json")
                    .build();

        } catch (SQLException e) {
            e.printStackTrace();
            return  Response.status(500)
                    .entity(new Message("operacion fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }
    }

    @GET
    @Path("all")
    public Response getAll(){

        try {
            TaskProvider provider = new TaskProvider();
            ArrayList<Task> tasks = provider.getAllTasks();
            return Response
                    .ok(tasks)
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response
                    .status(500)
                    .entity(new Message("operacion fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }
    }


    @PUT
    @Path("edit")
    @Produces("application/json")
    public Response edit (Task task){

        try {
            TaskProvider provider = new TaskProvider();
            provider.edit(task);
            return Response
                    .ok(new Message("Operacion exitosa"))
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response
                    .status(500)
                    .entity(new Message("operacion fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }
    }

    @DELETE
    @Path("delete/{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") int id){

        try {
            TaskProvider provider = new TaskProvider();
            provider.deleteById(id);
            return Response
                    .ok(new Message("Operacion exitosa"))
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response
                    .status(500)
                    .entity(new Message("operacion fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }
    }

    @GET
    @Path("select/{id}")
    public Response select(@PathParam("id") int id){
            System.out.println(id);
        try {
            TaskProvider provider = new TaskProvider();
            Task tasks = provider.selectById(id);
            System.out.println(tasks.getNombre());
            return Response
                    .ok(tasks)
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response
                    .status(500)
                    .entity(new Message("operacion fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }
    }

    @GET
    @Path("TODO")
    public Response getTODO(){

        try {
            TaskProvider provider = new TaskProvider();
            ArrayList<Task> tasks = provider.getAllTODO();
            return Response
                    .ok(tasks)
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response
                    .status(500)
                    .entity(new Message("operacion fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }
    }

    @GET
    @Path("DOING")
    public Response getDOING(){

        try {
            TaskProvider provider = new TaskProvider();
            ArrayList<Task> tasks = provider.getAllDOING();
            return Response
                    .ok(tasks)
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response
                    .status(500)
                    .entity(new Message("operacion fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }
    }
    @GET
    @Path("DONE")
    public Response getDONE(){

        try {
            TaskProvider provider = new TaskProvider();
            ArrayList<Task> tasks = provider.getAllDONE();
            return Response
                    .ok(tasks)
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response
                    .status(500)
                    .entity(new Message("operacion fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }
    }
}

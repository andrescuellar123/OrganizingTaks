package providers;

import db.DBConnection;
import model.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TaskProvider {

    //NOMBRE DE LA TABLA tasks
    public void create(Task task) throws SQLException {
        Date fecha = new Date();
        // se ha de poner la tabla que es de to do
        String sql =  "INSERT INTO A00359221tasksManager(nombre,  descripcion,  fecha , state) VALUES ('$NOMBRE','$DESCRIPCION','$FECHA' ,'$STATE')";
        sql = sql.replace("$NOMBRE", task.getNombre());
        sql = sql.replace("$DESCRIPCION", task.getDescripcion());
        sql = sql.replace("$FECHA", ""+fecha.toString());
        sql = sql.replace("$STATE", "TODO");
        DBConnection connection =  new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();

    }

    public  ArrayList<Task>getAllTasks() throws SQLException {

        ArrayList <Task> output = new ArrayList<>();

        String sql = "SELECT * FROM A00359221tasksManager";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(resultSet.findColumn("id"));
            String nombre = resultSet.getString(resultSet.findColumn("nombre"));
            String description = resultSet.getString(resultSet.findColumn("descripcion"));
            String fecha = resultSet.getString(resultSet.findColumn("fecha"));
            String state = resultSet.getString(resultSet.findColumn("state"));

            Task task = new Task(id,nombre,description,fecha,state);
            output.add(task);
        }
        connection.disconnect();

        return output;
    }

    public void edit(Task task) throws SQLException {
        String sql = "UPDATE A00359221tasksManager SET nombre= '$NOMBRE',descripcion='$DESCRIPCION', fecha= '$FECHA' , state = '$STATE'  WHERE id = $ID";
        Date fecha = new Date();
        sql = sql.replace("$ID", String.valueOf(task.getId()));
        sql = sql.replace("$NOMBRE", task.getNombre());
        sql = sql.replace("$DESCRIPCION", task.getDescripcion());
        sql = sql.replace("$FECHA",""+fecha.toString() );
        sql = sql.replace("$STATE",""+task.getState() );
        DBConnection connection =  new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM A00359221tasksManager WHERE id ="+id;
        DBConnection connection =  new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public Task selectById(int id) throws SQLException {
        String sql = "SELECT * FROM A00359221tasksManager WHERE id ="+id;
        DBConnection connection = new DBConnection();
        connection.connect();
        Task task=new Task();
        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            int id1 = resultSet.getInt(resultSet.findColumn("id"));
            String nombre = resultSet.getString(resultSet.findColumn("nombre"));
            String description = resultSet.getString(resultSet.findColumn("descripcion"));
            String fecha = resultSet.getString(resultSet.findColumn("fecha"));
            String state = resultSet.getString(resultSet.findColumn("state"));
             task = new Task(id1,nombre,description,fecha,state);

        }
        connection.disconnect();

        return task;
    }

    public  ArrayList<Task>getAllTODO() throws SQLException {

        ArrayList <Task> output = new ArrayList<>();

        String sql = "SELECT * FROM A00359221tasksManager WHERE state LIKE 'TODO'";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(resultSet.findColumn("id"));
            String nombre = resultSet.getString(resultSet.findColumn("nombre"));
            String description = resultSet.getString(resultSet.findColumn("descripcion"));
            String fecha = resultSet.getString(resultSet.findColumn("fecha"));
            String state = resultSet.getString(resultSet.findColumn("state"));

            Task task = new Task(id,nombre,description,fecha,state);
            output.add(task);
        }
        connection.disconnect();

        return output;
    }


    public  ArrayList<Task>getAllDOING() throws SQLException {

        ArrayList <Task> output = new ArrayList<>();

        String sql = "SELECT * FROM A00359221tasksManager WHERE state LIKE 'DOING'";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(resultSet.findColumn("id"));
            String nombre = resultSet.getString(resultSet.findColumn("nombre"));
            String description = resultSet.getString(resultSet.findColumn("descripcion"));
            String fecha = resultSet.getString(resultSet.findColumn("fecha"));
            String state = resultSet.getString(resultSet.findColumn("state"));

            Task task = new Task(id,nombre,description,fecha,state);
            output.add(task);
        }
        connection.disconnect();

        return output;
    }

    public  ArrayList<Task>getAllDONE() throws SQLException {

        ArrayList <Task> output = new ArrayList<>();

        String sql = "SELECT * FROM A00359221tasksManager WHERE state LIKE 'DONE'";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(resultSet.findColumn("id"));
            String nombre = resultSet.getString(resultSet.findColumn("nombre"));
            String description = resultSet.getString(resultSet.findColumn("descripcion"));
            String fecha = resultSet.getString(resultSet.findColumn("fecha"));
            String state = resultSet.getString(resultSet.findColumn("state"));

            Task task = new Task(id,nombre,description,fecha,state);
            output.add(task);
        }
        connection.disconnect();

        return output;
    }
}

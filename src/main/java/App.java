import com.google.gson.Gson;
import dao.Sql2oEmployeeDao;
import dao.Sql2oDepartmentDao;
import models.Department;
import models.Employee;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oEmployeeDao employeeDao;
        Sql2oDepartmentDao departmentDao;

        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/organization.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        employeeDao = new Sql2oEmployeeDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();


        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });

        get("/departments", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(departmentDao.getAll());
        });

        get("/departments/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentDao.findById(departmentId));
        });
    }
}
package dao;

import models.DepartmentNews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oDepartmentNewsDao implements DepartmentNewsDao{
    private final Sql2o sql2o;

    public Sql2oDepartmentNewsDao(Sql2o sql2o) {

        this.sql2o = sql2o;
    }

        @Override
    public void addDepartmental(DepartmentNews departmentNews) {
        String sql = "INSERT INTO news (topic, content, type, deptId) VALUES (:topic, :content, :type, :deptId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(departmentNews)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
            departmentNews.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}

package dao;

import models.Department;
import models.DepartmentNews;
import models.News;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {
    private static Sql2oNewsDao newsDao;
    private static Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public News generalNews(){
        return new News("one", "twenty");
    }

    public DepartmentNews deptNews1(){
        return new DepartmentNews("two", "ten", 1);
    }

    @Test
    public void whenNewsIsAddedDatabaseSetsId() throws Exception{
        News news = generalNews();
        DepartmentNews departmentNews = deptNews1();
        int generalId = news.getId();
        int deptId = departmentNews.getId();
        newsDao.add(news);
        newsDao.add(departmentNews);
        assertNotEquals(generalId, news.getId());
        assertNotEquals(deptId, departmentNews.getId());
    }

    @Test
    public void newsCanBeFoundById() throws Exception{
        News news = generalNews();
        newsDao.add(news);
        News foundNews = newsDao.findById(news.getId());
        assertEquals(news, foundNews);
    }

    @Test
    public void getAllNewsReturnsGeneralAndDepartmentNews() throws Exception{
        News news = generalNews();
        DepartmentNews departmentNews = deptNews1();
        newsDao.add(news);
        newsDao.add(departmentNews);
        assertEquals(2, newsDao.getAll().size());
    }

    @Test
    public void ifNoDepartmentExistsReturnsEmpty() throws Exception{
        assertEquals(0, departmentDao.getAll().size());
    }

    @Test
    public void updateDepartmentInformation() throws Exception{
        Department department = testDepartment();
        departmentDao.add(department);
        departmentDao.update(department.getId(), "security", "safety first", 4);
        Department newDepartment = departmentDao.findById(department.getId());
        assertNotEquals(department.getDeptName(), newDepartment.getDeptName());
        assertNotEquals(department.getDescription(), newDepartment.getDescription());
        assertNotEquals(department.getNoOfEmployees(), newDepartment.getNoOfEmployees());
    }

    @Test
    public void deleteByIdDeletesSingleDepartment() throws Exception {
        Department department = testDepartment();
        Department secondDepartment = new Department("hr", "deals with all employees", 4);
        departmentDao.add(department);
        departmentDao.add(secondDepartment);
        departmentDao.deleteById(department.getId());
        assertEquals(1, departmentDao.getAll().size());
    }

    @Test
    public void deleteAllClearsAllDepartments() throws Exception{
        Department department = testDepartment();
        Department secondDepartment = new Department("hr", "deals with all employees", 4);
        departmentDao.add(department);
        departmentDao.add(secondDepartment);
        departmentDao.clearAllDepartments();
        assertEquals(0, departmentDao.getAll().size());
    }
}
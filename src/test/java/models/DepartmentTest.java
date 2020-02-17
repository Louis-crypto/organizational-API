package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    Department testDepartment(){
        return new Department("Finance","Deals with money issues",12);
    }

    @Test
    public void departmentInstantiatesCorrectly_true(){
    Department newDepartment = testDepartment();
    assertTrue(newDepartment instanceof Department);
    }

    @Test
    public void getDeptNameReturnsDeptName_finance(){
        Department newDepartment = testDepartment();
        assertEquals("Finance", newDepartment.getDeptname());
    }

    @Test
    public void getDescriptionReturnsDescription(){
        String description = testDepartment().getDescription();
        assertEquals(description, testDepartment().getDescription());
    }

    public void getNumberOfEmployeesReturnsNumberOfEmployeesInADepartment_12(){
        Department newDepartment = testDepartment();
        assertEquals(12, newDepartment.getNoOfEmployees());
    }
}
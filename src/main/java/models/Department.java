package models;

public class Department {
    private String Deptname;
    private String description;
    private int noOfEmployees;
    private int id;

    public Department(String Deptname, String description, int noOfEmployees){
        this.Deptname = Deptname;
        this.description = description;
        this.noOfEmployees = noOfEmployees;
    }
}

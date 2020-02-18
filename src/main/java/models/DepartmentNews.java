package models;

public class DepartmentNews extends News {
    private int deptId;
    private int id;
    public static final String DATABASE_TYPE = "Departmental";
    public DepartmentNews(String topic, String content, int deptId) {
        super(topic, content);
        this.deptId = deptId;
        String type = DATABASE_TYPE;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}

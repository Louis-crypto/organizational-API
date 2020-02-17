package models;

public class DepartmentNews extends News {
    private int deptId;
    private int id;
    public DepartmentNews(String topic, String content, int deptId) {
        super(topic, content);
        this.deptId = deptId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
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

package models;

public class DepartmentNews{
    private String topic;
    private String content;
    private int deptId;
    private int id;

    public DepartmentNews(String topic, String content, int deptId) {
        this.topic = topic;
        this.content = content;
        this.deptId = deptId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

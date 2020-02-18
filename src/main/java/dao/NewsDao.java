package dao;

import models.DepartmentNews;
import models.News;

import java.util.List;

public interface NewsDao {
    //create
    void addGeneral(News news);
    void addDepartmental(DepartmentNews departmentNews);

    //read
    List<News> getAllGeneral();
    List<DepartmentNews> getAllDepartmental();

    // READ
    News findGeneralById(int id);
    DepartmentNews findDepartmentalById(int id);

    //update
    void update(int id, String topic, String content);

    //delete
    void deleteById(int id);
    void clearAllNews();
}

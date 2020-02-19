package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentNewsTest{
    DepartmentNews testNews(){
        return new DepartmentNews("one","five",1);
    }

    @Test
    public void departmentNewsInstantiatesCorrectly(){
        DepartmentNews news = testNews();
        assertTrue(news instanceof DepartmentNews);
    }

    @Test
    public void departmentNewsCanGetDepartmentIdCorrectly(){
        DepartmentNews news = testNews();
        int myDept = news.getDeptId();
        assertEquals(1, myDept);
    }

    @Test
    public void setDeptIdSetsIdOfADept(){
        DepartmentNews news = testNews();
        news.setDeptId(2);
        assertEquals(2, news.getDeptId());
    }

    @Test
    public void departmentNewsGetsTopicCorrectly_one(){
        DepartmentNews departmentNews = testNews();
        assertEquals("one", departmentNews.getTopic());
    }

    @Test
    public void departmentNewsGetsContentCorectly_five(){
        News news1 = testNews();
        assertEquals("12345", news1.getContent());
    }

    @Test
    public void settersWorkCorrectlyInSettingNewValues(){
        News news1 = testNews();
        news1.setTopic("two");
        news1.setContent("6789");
        assertEquals("two", news1.getTopic());
        assertEquals("6789", news1.getContent());
    }
}
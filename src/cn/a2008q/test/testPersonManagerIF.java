package cn.a2008q.test;

import cn.a2008q.pojo.sub.Student;
import cn.a2008q.pojo.sub.Teacher;
import cn.a2008q.service.PersonManagerIF;
import cn.a2008q.service.impl.PersonManager;
import org.junit.Test;

public class testPersonManagerIF {
    PersonManagerIF personManagerIF = new PersonManager();

    @Test
    public void testAdd() {
        personManagerIF.addPerson(new Student(1, "张三", 10, "湖南", 1, "java"));
        personManagerIF.addPerson(new Teacher(2, "李四", 18, "江苏", 1, "java"));
        personManagerIF.queryAllPerson();
    }
    @Test
    public void testQueryOne(){
        personManagerIF.addPerson(new Student(1, "张三", 10, "湖南", 1, "java"));
        personManagerIF.addPerson(new Teacher(2, "李四", 18, "江苏", 1, "java"));
        personManagerIF.queryOne(2);
    }
    @Test
    public void testUpdatePerson(){
        personManagerIF.addPerson(new Student(1, "张三", 10, "湖南", 1, "java"));
        personManagerIF.addPerson(new Teacher(2, "李四", 18, "江苏", 1, "java"));
        personManagerIF.updatePerson(new Student(1,"王五",11,"长沙",1,"python"));
        personManagerIF.queryOne(1);
    }
    @Test
    public void testDeletePerson(){
        personManagerIF.addPerson(new Student(1, "张三", 10, "湖南", 1, "java"));
        personManagerIF.addPerson(new Teacher(2, "李四", 18, "江苏", 1, "java"));
        personManagerIF.deleteOne(1);
        personManagerIF.queryAllPerson();
        personManagerIF.queryOne(2);
    }
}

package cn.a2008q.service.impl;

import cn.a2008q.pojo.Person;
import cn.a2008q.pojo.sub.Student;
import cn.a2008q.pojo.sub.Teacher;
import cn.a2008q.service.PersonManagerIF;
import cn.a2008q.utils.C3P0Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonManagerSql implements PersonManagerIF {
    private final List<Person> personList = new ArrayList<>();
    Connection conn = C3P0Utils.getConnection();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public void addPerson(Person person) {
        if (person instanceof Student){
            try {
                Student student = (Student) person;
                String stu_sql = "insert into student values(?,?,?,?,?,?)";
                preparedStatement = conn.prepareStatement(stu_sql);
                preparedStatement.setInt(1,student.getId());
                preparedStatement.setString(2,student.getName());
                preparedStatement.setInt(3,student.getAge());
                preparedStatement.setString(4,student.getAddress());
                preparedStatement.setInt(5,student.getStuNo());
                preparedStatement.setString(6,student.getClassName());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if (person instanceof Teacher){
            try {
                Teacher teacher = (Teacher) person;
                String tea_sql = "insert into teacher values(?,?,?,?,?,?)";
                preparedStatement = conn.prepareStatement(tea_sql);
                preparedStatement.setInt(1,teacher.getId());
                preparedStatement.setString(2,teacher.getName());
                preparedStatement.setInt(3,teacher.getAge());
                preparedStatement.setString(4,teacher.getAddress());
                preparedStatement.setInt(5,teacher.getTeaNo());
                preparedStatement.setString(6,teacher.getSubject());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
//        personList.add(person);
    }

    @Override
    public void updatePerson(Person person) {
        if (person instanceof Student){
            try {
                Student student = (Student) person;
                String stu_sql = "update student set name=?,age=?,address=?,stuno=?,classname=? where id=?";
                preparedStatement = conn.prepareStatement(stu_sql);
                preparedStatement.setInt(6,student.getId());
                preparedStatement.setString(1,student.getName());
                preparedStatement.setInt(2,student.getAge());
                preparedStatement.setString(3,student.getAddress());
                preparedStatement.setInt(4,student.getStuNo());
                preparedStatement.setString(5,student.getClassName());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if (person instanceof Teacher){
            try {
                Teacher teacher = (Teacher) person;
                String tea_sql = "update teacher set name=?,age=?,address=?,teano=?,subject=? where id=?";
                preparedStatement = conn.prepareStatement(tea_sql);
                preparedStatement.setInt(6,teacher.getId());
                preparedStatement.setString(1,teacher.getName());
                preparedStatement.setInt(2,teacher.getAge());
                preparedStatement.setString(3,teacher.getAddress());
                preparedStatement.setInt(4,teacher.getTeaNo());
                preparedStatement.setString(5,teacher.getSubject());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void queryAllPerson() {
        try {
            String stu_sql = "select * from student";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(stu_sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                printStudent(id);
//                personList.add();
            }
            String tea_sql = "select * from teacher";
            resultSet = statement.executeQuery(tea_sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                printTeacher(id);
//                personList.add(new Teacher(id,name,age,address,teano,subject));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void queryOne(int id) {
        try {
            String sql = "select * from student where id=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                printStudent(id);
            }else {
                sql = "select * from teacher where id=?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setInt(1,id);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    printTeacher(id);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void printStudent(int id) throws SQLException {
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String address = resultSet.getString("address");
        int stuno = resultSet.getInt("stuno");
        String classname = resultSet.getString("classname");
        System.out.println(new Student(id,name,age,address,stuno,classname).toString());
    }

    public void printTeacher(int id) throws SQLException {
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String address = resultSet.getString("address");
        int teano = resultSet.getInt("teano");
        String subject = resultSet.getString("subject");
        System.out.println(new Teacher(id,name,age,address,teano,subject).toString());
    }

    @Override
    public void deleteOne(int id) {
        try {
            String sql = "delete from student where id=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int result = preparedStatement.executeUpdate();
            if (result==0){
                sql = "delete from teacher where id=?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

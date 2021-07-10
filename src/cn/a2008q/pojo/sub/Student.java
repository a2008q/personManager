package cn.a2008q.pojo.sub;

import cn.a2008q.pojo.Person;

public class Student extends Person {
    private int stuNo;
    private String className;

    public Student(int id, String name, int age, String address, int stuNo, String className) {
        super(id, name, age, address);
        this.stuNo = stuNo;
        this.className = className;
    }

    public Student(int stuNo, String className) {
        this.stuNo = stuNo;
        this.className = className;
    }

    public Student() {
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Student{" +
                "stuNo=" + stuNo +
                ", className='" + className + '\'' +
                '}';
    }
}

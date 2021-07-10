package cn.a2008q.pojo.sub;

import cn.a2008q.pojo.Person;

public class Teacher extends Person {
    private int teaNo;
    private String subject;

    public Teacher(int id, String name, int age, String address, int teaNo, String subject) {
        super(id, name, age, address);
        this.teaNo = teaNo;
        this.subject = subject;
    }

    public Teacher(int teaNo, String subject) {
        this.teaNo = teaNo;
        this.subject = subject;
    }

    public Teacher() {
    }

    public int getTeaNo() {
        return teaNo;
    }

    public void setTeaNo(int teaNo) {
        this.teaNo = teaNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Teacher{" +
                "teaNo=" + teaNo +
                ", subject='" + subject + '\'' +
                '}';
    }
}

package cn.a2008q.ui;

import cn.a2008q.pojo.sub.Student;
import cn.a2008q.pojo.sub.Teacher;
import cn.a2008q.service.PersonManagerIF;

import java.util.Scanner;

public class ConsoleUI {
//    PersonManagerIF personManager = new PersonManager();
    PersonManagerIF personManager;
    Scanner sc = new Scanner(System.in);

    public ConsoleUI(PersonManagerIF personManager) {
        this.personManager = personManager;
    }

    public ConsoleUI() {
    }

    public void startApp() {
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("-------人员管理系统---------------");
            System.out.println("--------------------------------");
            System.out.println("------1. 添加学生/老师-----------");
            System.out.println("------2. 查询所有人员------------");
            System.out.println("------3. 查询单个人员------------");
            System.out.println("------4. 修改单个人员------------");
            System.out.println("------5. 删除单个人员------------");
            System.out.println("------0. 退出系统------------");
            System.out.println("--------------------------------");
            System.out.println("------请输入相应数字选择操作： ----");
            int num = sc.nextInt();
            if (num == 0) {
                System.out.println("退出系统");
                break;
            }
            switch (num) {
                case 1:
                    showAdd();
                    break;
                case 2:
                    showQueryAll();
                    break;
                case 3:
                    showQueryOne();
                    break;
                case 4:
                    showUpdateOne();
                    break;
                case 5:
                    showDeleteOne();
                    break;
            }
        }
    }

    private void showDeleteOne() {
        System.out.println("请输入删除的人员id");
        int id = sc.nextInt();
        personManager.deleteOne(id);
    }

    private void showUpdateOne() {
        System.out.println("请选择 1.修改老师 2.修改学生");
        int num = sc.nextInt();
        if (1 == num) {
            System.out.println("请输入要修改的老师编号");
            int id = sc.nextInt();
            System.out.println("请输入新的老师姓名");
            String name = sc.next();
            System.out.println("请输入新的老师年龄");
            int age = sc.nextInt();
            System.out.println("请输入新的老师地址");
            String address = sc.next();
            System.out.println("请输入新的老师工号");
            int teaNo = sc.nextInt();
            System.out.println("请输入新的老师科目");
            String subject = sc.next();
            personManager.updatePerson(new Teacher(id, name, age, address, teaNo, subject));
        } else if (2 == num) {
            System.out.println("请输入要修改的学生编号");
            int id = sc.nextInt();
            System.out.println("请输入新的学生姓名");
            String name = sc.next();
            System.out.println("请输入新的学生年龄");
            int age = sc.nextInt();
            System.out.println("请输入新的学生地址");
            String address = sc.next();
            System.out.println("请输入新的学生学号");
            int stuNo = sc.nextInt();
            System.out.println("请输入新的学生班级");
            String className = sc.next();
            personManager.updatePerson(new Student(id, name, age, address, stuNo, className));
        }
    }

    private void showQueryOne() {
        System.out.println("请输入查询的人员id");
        int id = sc.nextInt();
        personManager.queryOne(id);
    }

    private void showQueryAll() {
        personManager.queryAllPerson();
    }

    private void showAdd() {
        System.out.println("请选择 1.添加老师 2.添加学生");
        int num = sc.nextInt();
        if (1 == num) {
            System.out.println("请输入老师编号");
            int id = sc.nextInt();
            System.out.println("请输入老师姓名");
            String name = sc.next();
            System.out.println("请输入老师年龄");
            int age = sc.nextInt();
            System.out.println("请输入老师地址");
            String address = sc.next();
            System.out.println("请输入老师工号");
            int teaNo = sc.nextInt();
            System.out.println("请输入老师科目");
            String subject = sc.next();
            personManager.addPerson(new Teacher(id, name, age, address, teaNo, subject));
        } else if (2 == num) {
            System.out.println("请输入学生编号");
            int id = sc.nextInt();
            System.out.println("请输入学生姓名");
            String name = sc.next();
            System.out.println("请输入学生年龄");
            int age = sc.nextInt();
            System.out.println("请输入学生地址");
            String address = sc.next();
            System.out.println("请输入学生学号");
            int stuNo = sc.nextInt();
            System.out.println("请输入学生班级");
            String className = sc.next();
            personManager.addPerson(new Student(id, name, age, address, stuNo, className));
        }
    }
}

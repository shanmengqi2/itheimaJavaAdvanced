package com.itheima.studentInterface;

import java.util.ArrayList;

public class ClassM {
    private ArrayList<Student> stuList = new ArrayList<>();
    ClassOperator co = new ClassOperatorImplement_2();

    public ClassM() {
        Student stu = new Student("张三",'男',79);
        Student stu2 = new Student("李四",'男',89);
        Student stu3 = new Student("王五",'女',83);
        Student stu4 = new Student("赵六",'女',62);
        Student stu5 = new Student("黑马",'男',95);
        Student stu6 = new Student("zhangsan",'男',79);
        Student stu7 = new Student("lisi",'女',59);
        Student stu8 = new Student("wangwu",'女',93);
        Student stu9 = new Student("zhaoliu",'男',68);
        Student stu10 = new Student("heima",'男',77);
        stuList.add(stu);
        stuList.add(stu2);
        stuList.add(stu3);
        stuList.add(stu4);
        stuList.add(stu5);
        stuList.add(stu6);
        stuList.add(stu7);
        stuList.add(stu8);
        stuList.add(stu9);
        stuList.add(stu10);
    }


    public void printInfo(){
        co.printAllInfo(stuList);
    }

    public void printGrade(){
        co.printAvgGrade(stuList);
    }
}

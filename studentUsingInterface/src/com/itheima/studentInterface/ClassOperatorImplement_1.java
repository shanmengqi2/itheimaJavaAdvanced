package com.itheima.studentInterface;

import java.util.ArrayList;

public class ClassOperatorImplement_1 implements ClassOperator{

    @Override
    public void printAllInfo(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.print(student.getStuName() + student.getStuGender() + student.getStuGrade());
            System.out.println();
        }
    }

    @Override
    public void printAvgGrade(ArrayList<Student> students) {
        double sum = 0;
        double avg = 0;
        for (Student student : students) {
            sum += student.getStuGrade();
        }
        avg = sum / students.size();
        System.out.println("全班学生平均分为："+avg);
    }
}

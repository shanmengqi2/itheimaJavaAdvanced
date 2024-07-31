package com.itheima.studentInterface;

import java.util.ArrayList;

public class ClassOperatorImplement_2 implements ClassOperator{

    @Override
    public void printAllInfo(ArrayList<Student> students) {
        int boyNum = 0;
        int girlNum = 0;
        for (Student student : students) {
            System.out.println(student.getStuName() + student.getStuGender() + student.getStuGrade());

            if (student.getStuGender() == '男') {
                boyNum++;
            } else {
                girlNum++;
            }
        }

        System.out.println("男生人数为："+boyNum);
        System.out.println("女生人数为："+girlNum);
    }

    @Override
    public void printAvgGrade(ArrayList<Student> students) {
        double sum = 0;
        double avg = 0;
        double highest = students.getFirst().getStuGrade();
        double lowest = students.getFirst().getStuGrade();
        for (Student student : students) {
            sum += student.getStuGrade();
            if (student.getStuGrade() > highest) {
                highest = student.getStuGrade();
            }
            if (student.getStuGrade() < lowest) {
                lowest = student.getStuGrade();
            }
        }
        sum = sum - highest - lowest;
        avg = sum / (students.size()-2);
        System.out.println("最高分为："+highest);
        System.out.println("最低分为："+lowest);
        System.out.println("去除最高分和最低分之后的班级平均分为："+avg);
    }
}

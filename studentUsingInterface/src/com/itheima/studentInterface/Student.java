package com.itheima.studentInterface;

public class Student {
    private String stuName;
    private char stuGender;
    private double stuGrade;

    public Student(){

    }

    public Student(String stuName, char stuGender, double stuGrade) {
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuGrade = stuGrade;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public char getStuGender() {
        return stuGender;
    }

    public void setStuGender(char stuGender) {
        this.stuGender = stuGender;
    }

    public double getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(double stuGrade) {
        this.stuGrade = stuGrade;
    }
}

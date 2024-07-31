package com.itheima.studentInterface.studentInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassM implements PrintInfo{

    //班级管理类
    private ArrayList<Student> stuAlist = new ArrayList<>();

    public static int plan;

    //指定切换方案
//    public static void changePlan(int plan){
//        ClassM.plan = plan;
//        System.out.println("Change plan to " + plan);
//    }

    //自动切换方案
    public static void changePlan(){
        if (ClassM.plan == 1){
            ClassM.plan = 2;
        }
        else{
            ClassM.plan = 1;
        }

        System.out.println("Change plan to " + plan);
    }

    //带方案构造函数
    public ClassM(int plan){
        ClassM.plan = plan;
        System.out.println("Your plan is " + plan);
    }


    //欢迎界面
    public void homePage(){
        System.out.println("欢迎来到班级信息管理系统");
        System.out.println("添加学生信息，请输入1");
        System.out.println("打印全班学生信息，请输入2");
        System.out.println("打印全班平均成绩，请输入3");
        System.out.println("切换方案请输入4，当前为方案："+ClassM.plan);
        System.out.println("输入其它数字退出系统");

        Scanner sc = new Scanner(System.in);

        while (true) {
            int inputMenu = 0;
            try {
                inputMenu = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("未输入数字，已退出！");
                break;
                //throw new RuntimeException(e);

            }
            switch (inputMenu){
                case 1:{
                    studentInfoPreset();
                    System.out.println("已插入预设学生测试数据");
                    break;
                }
                case 2:{
                    printStudentInfo();
                    break;
                }
                case 3:{
                    printGrade();
                    break;
                }
                case 4:{
                    changePlan();
                    break;
                }
                default:
                    System.out.println("已退出系统");
                    for(Student st:this.getStuList()){
                        System.out.println(st);
                    }
                    System.exit(0);
            }
        }

    }

    //输入学生信息至ArrayList
    public void insertStudent(){
        //一次性录入5个学生信息，便于测试
        for (int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入学生姓名：");
            String name = sc.nextLine();
            System.out.println("请输入学生性别：");
            char gender = sc.nextLine().charAt(0);
            System.out.println("请输入学生成绩：");
            double grade = Double.parseDouble(sc.nextLine());
            Student stu = new Student(name, gender, grade);
            stuAlist.add(stu);
            System.out.println("添加学生信息成功！");
        }


        homePage();
    }

    //直接给出10个学生信息，便于测试
    public ArrayList<Student> studentInfoPreset(){
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
        stuAlist.add(stu);
        stuAlist.add(stu2);
        stuAlist.add(stu3);
        stuAlist.add(stu4);
        stuAlist.add(stu5);
        stuAlist.add(stu6);
        stuAlist.add(stu7);
        stuAlist.add(stu8);
        stuAlist.add(stu9);
        stuAlist.add(stu10);

        return stuAlist;
    }


    @Override
    public void printStudentInfo() {

        if(plan == 1){
            printStudentInfoNoGender();
        }
        else if(plan == 2){
            printStudentInfoWithGender();
        }
        else{
            System.out.println("暂无对应方案");
        }

    }

    //包含男女人数
    public void printStudentInfoWithGender() {
        int boyNum = 0;
        int girlNum = 0;
        for (Student student : stuAlist) {
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

    //不包含男女人数
    public void printStudentInfoNoGender() {
        for (Student student : stuAlist) {
            System.out.print(student.getStuName() + student.getStuGender() + student.getStuGrade());
            System.out.println();
        }
    }


    @Override
    public void printGrade() {
        if(plan == 1){
            printGradeAverage();
        }
        else if(plan == 2){
            printGradeAverageAdvanced();
        }
        else{
            System.out.println("暂无对应方案");
        }
    }

    //打印平均分
    public void printGradeAverage(){
        double sum = 0;
        double avg = 0;
        for (Student student : stuAlist) {
            sum += student.getStuGrade();
        }
        avg = sum / stuAlist.size();
        System.out.println("全班学生平均分为："+avg);
    }

    //打印去掉最高分和最低分的平均分
    public void printGradeAverageAdvanced(){

        double sum = 0;
        double avg = 0;
        double highest = stuAlist.getFirst().getStuGrade();
        double lowest = stuAlist.getFirst().getStuGrade();
        for (Student student : stuAlist) {
            sum += student.getStuGrade();
            if (student.getStuGrade() > highest) {
                highest = student.getStuGrade();
            }
            if (student.getStuGrade() < lowest) {
                lowest = student.getStuGrade();
            }
        }
        sum = sum - highest - lowest;
        avg = sum / (stuAlist.size()-2);
        System.out.println("最高分为："+highest);
        System.out.println("最低分为："+lowest);
        System.out.println("去除最高分和最低分之后的班级平均分为："+avg);

    }

    public ArrayList<Student> getStuList() {
        return stuAlist;
    }
}

package com.itheima.studentInterface.d2_polymorphism;

public class Test {
    public static void main(String[] args) {

        People p1 = new Student();
        p1.run();


        //强制类型转换
        Student s1 = (Student) p1;
        s1.test();

        //强制类型转换可能存在问题：编译阶段有继承或实现关系就可以强制转换，但是运行时可能出现类型转换异常
        //Teacher t1 = (Teacher) p1; //运行时出现了：ClassCastException

        if(p1 instanceof Student){
            Student s2 = (Student) p1;
            s2.test();
        }
        else {
            Teacher t2 = (Teacher) p1;
            t2.teach();
        }


        //好处2：可以使用父类类型的变量作为形参，可以接收一切子类对象
        Student s = new Student();
        go(s);


        Teacher t = new Teacher();
        go(t);

    }

    public static void go(People p){

        p.run();
        if(p instanceof Student){
            Student s1 = (Student) p;
            s1.test();
        }
        else {
            Teacher t2 = (Teacher) p;
            t2.teach();
        }

    }
}

package com.itheima.studentInterface.d2_polymorphism;

public class Teacher extends People{
    @Override
    public void run() {
        System.out.println("Teacher is running");
    }

    public void teach(){
        System.out.println("Teacher is teaching");
    }
}

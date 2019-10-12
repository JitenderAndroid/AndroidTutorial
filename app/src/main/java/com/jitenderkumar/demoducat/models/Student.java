package com.jitenderkumar.demoducat.models;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String rollno;
    private String age;
    private String standard;

    public Student() {
    }

    public Student(String name, String rollno, String age, String standard) {
        this.name = name;
        this.rollno = rollno;
        this.age = age;
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollno='" + rollno + '\'' +
                ", age='" + age + '\'' +
                ", standard='" + standard + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
}

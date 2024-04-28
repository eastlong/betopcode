package com.juc.test;

/**
 * @Description:
 * @Date 2023/10/31 10:14:00
 **/
public class Student {
    private String name;
    private Integer age;
    private String schoolClass;
    private String address;

    public Student(String name, Integer age, String schoolClass, String address) {
        this.name = name;
        this.age = age;
        this.schoolClass = schoolClass;
        this.address = address;
    }

    public String Student() {
        return "";
    }

    public Student () {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

/**
 * (base) PS D:\apps> javap -s Student
 * Compiled from "Student.java"
 * public class Student {
 *   public Student(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String);
 *     descriptor: (Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V
 *
 *   public java.lang.String Student();
 *     descriptor: ()Ljava/lang/String;
 *
 *   public Student();
 *     descriptor: ()V
 *
 *   public java.lang.String getName();
 *     descriptor: ()Ljava/lang/String;
 *
 *   public void setName(java.lang.String);
 *     descriptor: (Ljava/lang/String;)V
 *
 *   public java.lang.Integer getAge();
 *     descriptor: ()Ljava/lang/Integer;
 *
 *   public void setAge(java.lang.Integer);
 *     descriptor: (Ljava/lang/Integer;)V
 *
 *   public java.lang.String getSchoolClass();
 *     descriptor: ()Ljava/lang/String;
 *
 *   public void setSchoolClass(java.lang.String);
 *     descriptor: (Ljava/lang/String;)V
 *
 *   public java.lang.String getAddress();
 *     descriptor: ()Ljava/lang/String;
 *
 *   public void setAddress(java.lang.String);
 *     descriptor: (Ljava/lang/String;)V
 * }
 */
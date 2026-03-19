package com.TD.spring_introduction.model;

public class Student {
    public String Reference;
    public String Name;
    public String FirstName;
    public int Age;

    public Student() {}

    public String getReference() {
        return Reference;
    }

    public void setReference(String reference) {
        Reference = reference;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Reference='" + Reference + '\'' +
                ", Name='" + Name + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Age=" + Age +
                '}';
    }
}

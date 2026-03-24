package com.TD.spring_introduction.Entity;

public class Student {
    private String reference;
    private String name;
    private String lastName;

    public Student(String reference, String name, String lastName) {
        this.reference = reference;
        this.name = name;
        this.lastName = lastName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}

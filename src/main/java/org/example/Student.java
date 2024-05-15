package org.example;

public class Student {
    private int id;
    private String firstname;
    private String surname;

    public Student(int id, String firstname, String surname){
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
    }

    public String toString(){
        return id+ " " + firstname + " " + surname;
    }
}


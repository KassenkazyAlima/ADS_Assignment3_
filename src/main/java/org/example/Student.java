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
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public String toString(){
        return id+ " " + firstname + " " + surname;
    }
}


package ru.mustafina.springcourse.model;

public class Class_ {
    private int id;
    private String number;

    public Class_() {
    }

    public Class_(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

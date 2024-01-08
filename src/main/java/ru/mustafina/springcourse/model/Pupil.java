package ru.mustafina.springcourse.model;

public class Pupil {
    private int id;
    private String firstname;

    private String lastname;
    private int classId;

   public Pupil(){};

    public Pupil(int id, String name_pupil, int class_pupil) {
        this.id = id;
        this.firstname = name_pupil;
        this.classId = class_pupil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "id_pupil=" + id +
                ", name_pupil='" + firstname + '\'' +
                ", class_pupil=" + classId +
                '}';
    }
}

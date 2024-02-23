package ru.mustafina.springcourse.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Pupil {
    private int id;

    private int classId;
    @NotEmpty(message = "поле имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Длина должна быть от 2 до 10 символов")

    private String firstname;

    @NotEmpty(message = "поле фамилия не может быть пустым")
    @Size(min = 2, max = 50, message = "Длина должна быть от 2 до 10 символов")
    private String lastname;

    public Pupil() {
    }

    public Pupil(int id, int classId, String firstname, String lastname) {
        this.id = id;
        this.classId = classId;
        this.firstname = firstname;
        this.lastname = lastname;
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

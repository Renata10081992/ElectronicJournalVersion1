package ru.mustafina.springcourse.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class Mark {
    private int id;
    private int subjectId;
    private int pupilId;

    @Min(value = 2, message = "от 2-5")
    @Max(value = 5, message = "от 2-5")
    private Integer markValue;

    public Mark() {
    }

    public Mark(int id, int subjectId, int pupilId, int markValue) {
        this.id = id;
        this.subjectId = subjectId;
        this.pupilId = pupilId;
        this.markValue = markValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getPupilId() {
        return pupilId;
    }

    public void setPupilId(int pupilId) {
        this.pupilId = pupilId;
    }

    public int getMarkValue() {
        return markValue;
    }

    public void setMarkValue(int markValue) {
        this.markValue = markValue;
    }
}

package ru.mustafina.springcourse.model;

import java.util.Date;

public class Mark {
    private int id;
    private int subjectId;
    private int pupilId;
    private Integer markValue;
    private Date dateOfAssessment;

    public Mark() {
    }

    public Mark(int id, int subjectId, int pupilId, int markValue, Date dateOfAssessment) {
        this.id = id;
        this.subjectId = subjectId;
        this.pupilId = pupilId;
        this.markValue = markValue;
        this.dateOfAssessment = dateOfAssessment;
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

    public Date getDateOfAssessment() {
        return dateOfAssessment;
    }

    public void setDateOfAssessment(Date dateOfAssessment) {
        this.dateOfAssessment = dateOfAssessment;
    }
}

package ru.mustafina.springcourse;

import ru.mustafina.springcourse.model.Mark;
import ru.mustafina.springcourse.model.Pupil;

import java.util.List;

public class PupilMarksDto {
    private Pupil pupil;
    private List<Mark> mars;

    public Pupil getPupil() {
        return pupil;
    }

    public void setPupil(Pupil pupil) {
        this.pupil = pupil;
    }

    public List<Mark> getMars() {
        return mars;
    }

    public void setMars(List<Mark> mars) {
        this.mars = mars;
    }

}

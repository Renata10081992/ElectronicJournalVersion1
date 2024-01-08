package ru.mustafina.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mustafina.springcourse.PupilMarksDto;
import ru.mustafina.springcourse.dao.ClassDao;
import ru.mustafina.springcourse.dao.MarkDao;
import ru.mustafina.springcourse.dao.PupilDao;
import ru.mustafina.springcourse.dao.SubjectDao;
import ru.mustafina.springcourse.model.Class_;
import ru.mustafina.springcourse.model.Mark;
import ru.mustafina.springcourse.model.Pupil;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {

    private final ClassDao classDao;
    private final MarkDao markDao;
    private final SubjectDao subjectDao;

    private final PupilDao pupilDao;

    public ClassController(ClassDao classDao, MarkDao markDao, SubjectDao subjectDao, PupilDao pupilDao) {
        this.classDao = classDao;
        this.markDao = markDao;
        this.subjectDao = subjectDao;
        this.pupilDao = pupilDao;
    }

    @GetMapping("/{id}")
    public String getOneClass(@PathVariable("id") int id, @RequestParam("subjectId") Integer subjectId, Model model) {
        model.addAttribute("oneClass", classDao.readOne(id));
        model.addAttribute("subject", subjectDao.readOne(id));
        List<Pupil> pupils = pupilDao.getPupilsByClassId(id);
        List<PupilMarksDto> pupilMarksDtos = new ArrayList<>();
        for (Pupil pupil : pupils) {
            PupilMarksDto pupilMarksDto = new PupilMarksDto();
            pupilMarksDto.setPupil(pupil);
            pupilMarksDto.setMars(markDao.getMarksByPupilAndSubId(pupil.getId(), subjectId));
            pupilMarksDtos.add(pupilMarksDto);
        }
        model.addAttribute("dtos", pupilMarksDtos);
        model.addAttribute("newMark", new Mark());
        return ("classes/oneClass");
    }

    @GetMapping
    public String getClassList(Model model) {
        model.addAttribute("classList", classDao.readAll());
        return ("classes/classList");
    }
}

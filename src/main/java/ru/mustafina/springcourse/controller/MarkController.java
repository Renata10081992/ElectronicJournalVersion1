package ru.mustafina.springcourse.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mustafina.springcourse.PupilMarksDto;
import ru.mustafina.springcourse.dao.ClassDao;
import ru.mustafina.springcourse.dao.MarkDao;
import ru.mustafina.springcourse.dao.PupilDao;
import ru.mustafina.springcourse.dao.SubjectDao;
import ru.mustafina.springcourse.model.Mark;
import ru.mustafina.springcourse.model.Pupil;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mark")
public class MarkController {

    private final MarkDao markDao;
    private final PupilDao pupilDao;

    private final ClassDao classDao;

    private final SubjectDao subjectDao;

    public MarkController(MarkDao markDao, PupilDao pupilDao, ClassDao classDao, SubjectDao subjectDao) {
        this.markDao = markDao;
        this.pupilDao = pupilDao;
        this.classDao = classDao;
        this.subjectDao = subjectDao;
    }

    @GetMapping
    public String getMarksByClassIdAndSubId(@RequestParam("classId") int classId,
                           @RequestParam("subjectId") Integer subjectId, Model model) {
        model.addAttribute("oneClass", classDao.readOne(classId));
        model.addAttribute("subject", subjectDao.readOne(subjectId));
        List<Pupil> pupils = pupilDao.getPupilsByClassId(classId);
        List<PupilMarksDto> pupilMarksDtos = new ArrayList<>();
        for (Pupil pupil : pupils) {
            PupilMarksDto pupilMarksDto = new PupilMarksDto();
            pupilMarksDto.setPupil(pupil);
            List<Mark> markList = markDao.getMarksByPupilAndSubId(pupil.getId(), subjectId);
            pupilMarksDto.setMars(markList);
            double sum = 0;
            for (Mark mark: markList) {
                sum += mark.getMarkValue();
            }
            pupilMarksDto.setGpa(String.format("%,.2f", sum / markList.size()));
            pupilMarksDtos.add(pupilMarksDto);
        }
        model.addAttribute("pupilMarksMapping", pupilMarksDtos);
        model.addAttribute("newMark", new Mark());
        return ("marks/markListByClassAndSubject");
    }

    @PostMapping
    public String create(@ModelAttribute("newMark") @Valid Mark mark, BindingResult bindingResult,
                         @RequestHeader(value = HttpHeaders.REFERER, required = false) final String referrer) {
        if (bindingResult.hasErrors()) {
            return "redirect:" + referrer;
        }
        markDao.create(mark);
        return "redirect:" + referrer;
    }
}

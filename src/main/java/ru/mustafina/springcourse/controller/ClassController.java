package ru.mustafina.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mustafina.springcourse.dao.ClassDao;
import ru.mustafina.springcourse.dao.SubjectDao;

@Controller
@RequestMapping("/class")
public class ClassController {

    private final ClassDao classDao;
    private final SubjectDao subjectDao;

    public ClassController(ClassDao classDao, SubjectDao subjectDao) {
        this.classDao = classDao;
        this.subjectDao = subjectDao;
    }

    @GetMapping
    public String getClassesBySubjectId(@RequestParam(required = false) Integer subjectId, Model model) {
        if (subjectId == null) {
            model.addAttribute("classList", classDao.readAll());
            return ("classes/classList");
        }
        model.addAttribute("oneSubject", subjectDao.readOne(subjectId));
        model.addAttribute("classes", classDao.getClassesBySubjectId(subjectId));
        return ("classes/classesBySubjectId");
    }
}

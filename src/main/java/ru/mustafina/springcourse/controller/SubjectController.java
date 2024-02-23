package ru.mustafina.springcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mustafina.springcourse.dao.ClassDao;
import ru.mustafina.springcourse.dao.SubjectDao;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    public final SubjectDao subjectDao;
    public final ClassDao classDao;

    @Autowired
    public SubjectController(SubjectDao subjectDao, ClassDao classDao) {
        this.subjectDao = subjectDao;
        this.classDao = classDao;
    }

    @GetMapping()
    public String getSubjects(Model model) {
        model.addAttribute("subjects", subjectDao.readAll());
        return ("subjects/subjectList");
    }
}

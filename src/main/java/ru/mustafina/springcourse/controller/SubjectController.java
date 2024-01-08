package ru.mustafina.springcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return ("subjects/subject");
    }

    @GetMapping("/{id}")
    public String getOneSubject(@PathVariable("id") int id, Model model) {
        model.addAttribute("oneSubject", subjectDao.readOne(id));
        model.addAttribute("classes", classDao.getClassesBySubjectId(id));
        return ("subjects/oneSubject");
    }


//
//    @GetMapping("new")
//    public String newSubject(Model model) {
//        model.addAttribute("newSubject", new Subject());
//        return ("subjects/new");
//    }
//
//    @PostMapping()
//    public String createSubject(@ModelAttribute("newSubject") Subject subject) {
//        subjectDao.create(subject);
//        return ("redirect:/subject");
//    }
//
//    @GetMapping("/{id}/edit")
//    public String editSibject(@PathVariable("id") int id, Model model) {
//        model.addAttribute("updateSubject", subjectDao.readOne(id));
//        return ("subjects/edit");
//    }
//
//    @PatchMapping("/{id}")
//    public String updateSubject(@ModelAttribute("updateSubject") Subject subject, @PathVariable("id") int id) {
//        subjectDao.update(subject, id);
//        return ("redirect:/subject");
//    }
//
//    @GetMapping("/{id}")
//    public String deleteSubject(@PathVariable("id") int id) {
//        subjectDao.delete(id);
//        return ("redirect:/subject");
//    }
}

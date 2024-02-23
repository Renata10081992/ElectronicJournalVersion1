package ru.mustafina.springcourse.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mustafina.springcourse.dao.ClassDao;
import ru.mustafina.springcourse.dao.MarkDao;
import ru.mustafina.springcourse.dao.PupilDao;
import ru.mustafina.springcourse.model.Pupil;

@Controller
@RequestMapping("/pupil")
public class PupilController {

    private final PupilDao pupilDao;
    private final ClassDao classDao;

    private final MarkDao markDao;

    @Autowired
    public PupilController(PupilDao pupilDao, ClassDao classDao, MarkDao markDao) {
        this.pupilDao = pupilDao;
        this.classDao = classDao;
        this.markDao = markDao;
    }

    @GetMapping()
    public String getPupilsByClass(@RequestParam int classId, Model model) {
        model.addAttribute("oneClass", classDao.readOne(classId));
        model.addAttribute("pupilsByClass", pupilDao.getPupilsByClassId(classId));
        return "classes/pupilByClass";
    }
   @GetMapping("/{id}")
    public String getOnePupil(@PathVariable("id") int id, Model model) {
    model.addAttribute("onePupil", pupilDao.readOne(id));
       return ("pupils/onePupil");
  }

    @GetMapping("/new")
    public String newPupil(@RequestParam Integer classId, Model model) {
        Pupil newPupil = new Pupil();
        newPupil.setClassId(classId);
        model.addAttribute("newPupil", newPupil);
        return "pupils/new";
    }

    @PostMapping()
    public String createPupil(@ModelAttribute("newPupil") @Valid Pupil pupil, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "pupils/new";
        pupilDao.create(pupil);
        return "redirect:/pupil?classId=" + pupil.getClassId();
    }

    @DeleteMapping("/{id}")
    public String delete(@RequestParam Integer classId, @PathVariable("id") int id) {
        markDao.deleteByPupilId(id);
        pupilDao.delete(id);
        return "redirect:/pupil?classId=" + classId;
    }
}

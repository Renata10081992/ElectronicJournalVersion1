package ru.mustafina.springcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mustafina.springcourse.dao.ClassDao;
import ru.mustafina.springcourse.dao.PupilDao;
import ru.mustafina.springcourse.model.Pupil;

@Controller
@RequestMapping("/pupil")
public class PupilController {

    public final PupilDao pupilDao;
    public final ClassDao classDao;

    @GetMapping("/{id}")
    public String getListOfPupilByClass(@PathVariable ("id") int id, Model model) {
        model.addAttribute("oneClass", classDao.readOne(id));
        model.addAttribute("pupilsByClass", pupilDao.getPupilsByClassId(id));
        return "classes/pupilByClass";
    }

    @Autowired
    public PupilController(PupilDao pupilDao, ClassDao classDao) {
        this.pupilDao = pupilDao;
        this.classDao = classDao;
    }
//
//    @GetMapping
//    public String getPupils(Model model) {
//        model.addAttribute("pupils", pupilDao.read());
//        return ("pupils/pupil");
//    }
//
//    @GetMapping("/{id}")
//    public String getOnePupil(@PathVariable("id") int id, Model model) {
//        model.addAttribute("onePupil", pupilDao.readOne(id));
//        return ("pupils/onePupil");
//    }
//
//    @GetMapping("/new")
//    public String newPupil(Model model){
//        model.addAttribute("newPupil", new Pupil());
//        return ("pupils/new");
//    }
//
//    @PostMapping()
//    public String createPupil(@ModelAttribute ("newPupil") Pupil pupil) {
//        pupilDao.create(pupil);
//        return ("redirect:/pupil");
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable ("id") int id, Model model) {
//        model.addAttribute("updatePupil", pupilDao.readOne(id));
//        return ("pupils/edit");
//    }
//
//    @PatchMapping("/{id}")
//    public String update (@ModelAttribute ("updatePupil") Pupil pupil, @PathVariable ("id") int id) {
//       pupilDao.update(pupil,id);
//        return ("redirect:/pupil");
//    }
//    @GetMapping("/{id}")
//    public String delete (@PathVariable ("id") int id) {
//        pupilDao.delete(id);
//        return ("redirect:/pupil");
//    }
}

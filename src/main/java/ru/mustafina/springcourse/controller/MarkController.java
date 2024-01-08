package ru.mustafina.springcourse.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mustafina.springcourse.dao.MarkDao;
import ru.mustafina.springcourse.model.Mark;

@Controller
@RequestMapping("/mark")
public class MarkController {

    private final MarkDao markDao;

    public MarkController(MarkDao markDao) {
        this.markDao = markDao;
    }

    @PostMapping
    public String create(@ModelAttribute("newMark") Mark mark,
                         @RequestHeader(value = HttpHeaders.REFERER, required = false) final String referrer) {
        markDao.create(mark);
        return "redirect:" + referrer;
    }
}

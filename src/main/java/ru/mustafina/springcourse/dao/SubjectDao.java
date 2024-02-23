package ru.mustafina.springcourse.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.mustafina.springcourse.model.Class_;
import ru.mustafina.springcourse.model.Subject;

import java.util.List;

@Component
public class SubjectDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SubjectDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Subject> readAll() {
        return jdbcTemplate.query("select * from subject", new BeanPropertyRowMapper<>(Subject.class));
    }

    public Subject readOne(int id) {
        return jdbcTemplate.query("select * from subject where id=?", new BeanPropertyRowMapper<>(Subject.class), id).stream().findAny().orElse(null);
    }

}

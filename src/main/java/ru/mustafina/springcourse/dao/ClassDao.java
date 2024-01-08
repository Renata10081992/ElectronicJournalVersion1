package ru.mustafina.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.mustafina.springcourse.mapper.PupilMapper;
import ru.mustafina.springcourse.model.Class_;
import ru.mustafina.springcourse.model.Pupil;
import ru.mustafina.springcourse.model.Subject;

import java.util.List;

@Component
public class ClassDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClassDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Class_ readOne( int id) {
       return jdbcTemplate.query("select * from class_ where id=?",  new BeanPropertyRowMapper<>(Class_.class), id).stream().findAny().orElse(null);
    }

    public List<Class_> readAll() {
        return jdbcTemplate.query("select * from class_",  new BeanPropertyRowMapper<>(Class_.class));
    }

    public List<Class_> getClassesBySubjectId(int id) {
        return jdbcTemplate.query("select class_.* from class_ left join subject_to_class on class_.id=subject_to_class.class_id where subject_to_class.subject_id=?",new BeanPropertyRowMapper<>(Class_.class), id);
    }

}

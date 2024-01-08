package ru.mustafina.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.mustafina.springcourse.mapper.PupilMapper;
import ru.mustafina.springcourse.model.Pupil;

import java.util.List;

@Component
public class PupilDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PupilDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pupil> read() {
        return jdbcTemplate.query("select * from Pupil", new PupilMapper());
    }

    public Pupil readOne(int id) {
        return jdbcTemplate.query("Select * from Pupil where id_pupil=?", new Object[]{id}, new PupilMapper()).stream().findAny().orElse(null);
    }

    public List<Pupil> getPupilsByClassId(int classId) {
        return jdbcTemplate.query("select * from pupil where class_id=?", new BeanPropertyRowMapper<>(Pupil.class), classId);
    }

    public void create(Pupil p) {
        jdbcTemplate.update("Insert into Pupil (name_pupil, class_pupil) values (?, ?)", p.getId(), p.getClass());
    }

    public void update(Pupil p, int id) {
        jdbcTemplate.update("Update Pupil set name_pupil=?, class_pupil=? where id=?", p.getId(), p.getClass(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE from Pupil where id=?", id);
    }
}

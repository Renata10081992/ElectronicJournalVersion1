package ru.mustafina.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.mustafina.springcourse.model.Mark;

import java.util.List;

@Component
public class MarkDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MarkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Mark> getMarksByPupilAndSubId(int pupilId, int subId) {
        return jdbcTemplate.query("select * from mark where pupil_id=? and subject_id=?", new BeanPropertyRowMapper<>(Mark.class), pupilId, subId);
    }

    public void create(Mark mark) {
        jdbcTemplate.update("insert into mark (subject_id, pupil_id, mark_value) values ( ?, ?, ?)", mark.getSubjectId(),
                mark.getPupilId(), mark.getMarkValue());
    }

    public void deleteByPupilId(int pupilId) {
        jdbcTemplate.update("DELETE from mark where pupil_id = ?", pupilId);
    }

}

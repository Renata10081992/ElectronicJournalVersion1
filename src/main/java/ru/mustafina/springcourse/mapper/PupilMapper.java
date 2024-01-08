package ru.mustafina.springcourse.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.mustafina.springcourse.model.Pupil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PupilMapper implements RowMapper<Pupil> {

    @Override
    public Pupil mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pupil pupil=new Pupil();
        pupil.setId(rs.getInt("id_pupil"));
        pupil.setFirstname(rs.getString("name_pupil"));
        pupil.setClassId(rs.getInt("class_pupil"));
        return pupil;
    }
}

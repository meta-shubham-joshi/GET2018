package com.metacube.training.EmployeesPortal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeesPortal.model.Project;
import com.metacube.training.EmployeesPortal.model.Skill;

public class SkillMapper implements RowMapper<Skill>{
	
	public Skill mapRow(ResultSet resultSet, int i) throws SQLException {

		Skill skill = new Skill();
		skill.setId(resultSet.getInt("skill_id"));
		skill.setName(resultSet.getString("skill_name"));
		return skill;
	}

}


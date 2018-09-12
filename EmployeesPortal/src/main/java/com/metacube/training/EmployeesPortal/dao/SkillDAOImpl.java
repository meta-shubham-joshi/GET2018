package com.metacube.training.EmployeesPortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeesPortal.mappers.ProjectMapper;
import com.metacube.training.EmployeesPortal.mappers.SkillMapper;
import com.metacube.training.EmployeesPortal.model.Skill;

@Repository
public class SkillDAOImpl implements SkillDAO{
	
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SkillDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_GET_ALL = "select * from skill_master";
	private final String SQL_INSERT_SKILL = "insert into skill_master(skill_id, skill_name) values(?, ?)";
	private final String SQL_FIND_SKILL = "select * from skill_master where  skill_id  = ?";
	private final String SQL_DELETE_SKILL = "delete from skill_master where skill_id = ?";
	
	@Override
	public Skill getSkillById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_SKILL, new Object[] { id }, new SkillMapper());
	}

	@Override
	public boolean deleteSkill(Skill skill) {
		return jdbcTemplate.update(SQL_DELETE_SKILL, skill.getId()) > 0;
	}

	@Override
	public boolean addSkills(Skill skill) {
		return jdbcTemplate.update(SQL_INSERT_SKILL, skill.getId(), skill.getName()) > 0;
	}

	@Override
	public List<Skill> getAllSkills() {
		return  jdbcTemplate.query(SQL_GET_ALL, new SkillMapper());
	}
	
	

}

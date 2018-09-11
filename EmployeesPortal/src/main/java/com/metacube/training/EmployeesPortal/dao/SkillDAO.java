package com.metacube.training.EmployeesPortal.dao;

import java.util.List;

import com.metacube.training.EmployeesPortal.model.Project;
import com.metacube.training.EmployeesPortal.model.Skill;

public interface SkillDAO {

	Skill getSkillById(int id);

	boolean deleteSkill(Skill skill);

	boolean addSkills(Skill skill);

	List<Skill> getAllSkills();

}

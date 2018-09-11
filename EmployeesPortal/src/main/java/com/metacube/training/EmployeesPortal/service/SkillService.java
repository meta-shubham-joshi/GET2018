package com.metacube.training.EmployeesPortal.service;

import java.util.List;

import com.metacube.training.EmployeesPortal.model.Project;
import com.metacube.training.EmployeesPortal.model.Skill;

public interface SkillService {
	
	Skill getSkillById(int id);
	
	boolean deleteSkill(int id);

	boolean createSkill(Skill skill);

	List<Skill> getAllSkills();

}

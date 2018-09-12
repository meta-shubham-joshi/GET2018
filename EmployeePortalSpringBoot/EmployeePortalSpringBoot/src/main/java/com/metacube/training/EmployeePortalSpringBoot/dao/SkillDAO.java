package com.metacube.training.EmployeePortalSpringBoot.dao;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.Skill;

public interface SkillDAO {

	Skill getSkillById(int id);

	boolean deleteSkill(Skill skill);

	boolean addSkills(Skill skill);

	List<Skill> getAllSkills();

}

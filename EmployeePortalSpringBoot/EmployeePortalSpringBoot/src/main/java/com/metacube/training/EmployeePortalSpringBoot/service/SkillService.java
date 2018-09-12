package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.Skill;

public interface SkillService {

	Skill getSkillById(int id);

	boolean deleteSkill(int id);

	boolean createSkill(Skill skill);

	List<Skill> getAllSkills();

}

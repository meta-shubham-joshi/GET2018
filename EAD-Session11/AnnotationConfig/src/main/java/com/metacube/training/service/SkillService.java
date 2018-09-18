package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillService {

	Skill getSkillById(int id);

	boolean deleteSkill(int id);

	boolean createSkill(Skill skill);

	List<Skill> getAllSkills();

}

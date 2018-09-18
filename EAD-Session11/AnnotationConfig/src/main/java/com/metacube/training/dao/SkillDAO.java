package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillDAO {

	Skill getSkillById(int id);

	boolean deleteSkill(Skill skill);

	boolean addSkills(Skill skill);

	List<Skill> getAllSkills();

}

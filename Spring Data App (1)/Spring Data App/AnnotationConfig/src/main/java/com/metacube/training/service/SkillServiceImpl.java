package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
    private SkillRepository<Skill> skillRepository;

	@Override
	public Skill getSkillById(int id) {
		return skillRepository.findOne(id);
	}

	@Override
	public void deleteSkill(int id) {
		skillRepository.delete(id);
	}

	@Override
	public boolean createSkill(Skill skill) {
		skillRepository.save(skill);		
		return true;
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	
	
}

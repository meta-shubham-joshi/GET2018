package com.metacube.training.EmployeesPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeesPortal.dao.ProjectDAO;
import com.metacube.training.EmployeesPortal.dao.SkillDAO;
import com.metacube.training.EmployeesPortal.model.Project;
import com.metacube.training.EmployeesPortal.model.Skill;

@Service
public class SkillServiceImpl implements SkillService{

	@Autowired
	private SkillDAO skillDAO;
	
	@Override
	public Skill getSkillById(int id) {
		return skillDAO.getSkillById(id);
		
	}

	@Override
	public boolean deleteSkill(int id) {
		Skill skill = skillDAO.getSkillById(id);
		return skillDAO.deleteSkill(skill);
	}

	@Override
	public boolean createSkill(Skill skill) {
		return skillDAO.addSkills(skill);
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillDAO.getAllSkills();
	}
	
	

}

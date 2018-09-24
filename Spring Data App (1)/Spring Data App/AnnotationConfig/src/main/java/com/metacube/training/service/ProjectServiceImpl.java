package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	/*@Autowired
	private ProjectDAO projectDAO;*/
	
	@Autowired
    private ProjectRepository<Project> projectRepository;

	@Override
	public Project getProjectById(int id) {		
		return projectRepository.findOne(id);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public void deleteProject(int id) {
		projectRepository.delete(id);
	}

	@Override
	public int updateProject(Project project) {
		return projectRepository.updateProjectInfo(project.getName(), project.getDescription(),project.getStartDate(), project.getEndDate(),project.getId());
	}

	@Override
	public boolean createProject(Project project) {		
		projectRepository.save(project);		
		return true;
	}

	
}

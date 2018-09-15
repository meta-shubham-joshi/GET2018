package com.metacube.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.model.Project;

public interface ProjectService {

	Project getProjectById(int id);

	List<Project> getAllProjects();

	void deleteProject(int id);

	int updateProject(Project project);

	boolean createProject(Project project);

}

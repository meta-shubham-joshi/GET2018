package com.metacube.training.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;

@Repository
@Transactional
public interface ProjectRepository<P> extends JpaRepository<Project, Integer> {

	@Modifying(clearAutomatically = true)
	@Query("update Project project set project.name = ?1, project.description = ?2, project.startDate = ?3, project.endDate = ?4 where project.id = ?5")
	int updateProjectInfo(String name, String description, Date startDate,
			Date endDate, int id);

}

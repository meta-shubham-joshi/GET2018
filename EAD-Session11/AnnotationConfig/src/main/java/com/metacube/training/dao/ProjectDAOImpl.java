package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {
	
	@Autowired
	   private SessionFactory sessionFactory;

	private final String SQL_FIND_PROJECT = "from Project where project_id = :project_id";
	private final String SQL_DELETE_PROJECT = "delete from Project where project_id = :project_id";
	private final String SQL_UPDATE_PROJECT = "update Project set project_name = :project_name, project_description = :project_description, start_date  = :start_date, end_date  = :end_date where project_id = :project_id";
	private final String SQL_GET_ALL = "from Project";

	public Project getProjectById(int id) {
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery(SQL_FIND_PROJECT);
		query.setParameter("project_id", id);
		return query.getSingleResult();
	}

	public List<Project> getAllProjects() {
		//return jdbcTemplate.query(SQL_GET_ALL, new ProjectMapper());
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery(SQL_GET_ALL);
		return query.getResultList();
	}

	public boolean deleteProject(Project person) {
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery(SQL_DELETE_PROJECT);
		query.setParameter("project_id", person.getId());
		return (query.executeUpdate()>0);
	}

	public boolean updateProject(Project person) {
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery(SQL_UPDATE_PROJECT);
		query.setParameter("project_name", person.getName());
		query.setParameter("project_description", person.getDescription());
		query.setParameter("start_date", person.getStartDate());
		query.setParameter("end_date", person.getEndDate());
		query.setParameter("project_id", person.getId());
		return (query.executeUpdate()>0);
	}

	public void createProject(Project person) {		
		sessionFactory.getCurrentSession().save(person);
	}

}
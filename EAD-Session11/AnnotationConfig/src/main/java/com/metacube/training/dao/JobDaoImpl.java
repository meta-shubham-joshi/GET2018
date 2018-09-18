package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.JobMapper;
import com.metacube.training.model.Job;
import com.metacube.training.model.Project;

@Repository
public class JobDaoImpl implements JobDao {

	@Autowired
	   private SessionFactory sessionFactory;
	
	private final String SQL_GET_ALL = "from Job";

	@Override
	public boolean createJob(Job job) {

		int id = (Integer)sessionFactory.getCurrentSession().save(job);
		System.out.println(id);
		
		if(id>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Job> getJobs() {
		
		TypedQuery<Job> query = sessionFactory.getCurrentSession().createQuery(SQL_GET_ALL);
		return query.getResultList();
		
	}

}

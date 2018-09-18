package com.metacube.training.dao;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.mappers.JobDetailsMapper;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Project;

@Repository
@Transactional
public class JobDetailsServiceDAOImpl implements JobDetailsServiceDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final String SQL_FIND_JOBDETAILS = "from JobDetails where  emp_code  = :emp_code";
	private final String SQL_UPDATE_JOB_DETAILS = "update JobDetails set date_of_joining = :date_of_joining, total_exp  = :total_exp, job_code  = :job_code, reporting_mgr= :reporting_mgr, team_lead= :team_lead, curr_proj_id= :curr_proj_id where emp_code = :emp_code";

	@Override
	public JobDetails getJobDetailsByEmployeeCode(String empCode) {

		JobDetails jobDetails = null;
		try {
			TypedQuery<JobDetails> query = sessionFactory.getCurrentSession().createQuery(SQL_FIND_JOBDETAILS);
			query.setParameter("emp_code", empCode);
			return query.getSingleResult();
			
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			jobDetails = new JobDetails();
			jobDetails.setEmp_code(empCode);
		}
		return jobDetails;

	}

	@Override
	public boolean updateJobDetailsByEmployeeCode(JobDetails jobDetails) {
		
		TypedQuery<JobDetails> query = sessionFactory.getCurrentSession().createQuery(SQL_UPDATE_JOB_DETAILS);
		query.setParameter("date_of_joining", jobDetails.getDate_of_joining());
		query.setParameter("total_exp", jobDetails.getTotal_exp());
		query.setParameter("job_code", jobDetails.getJob_code());
		query.setParameter("reporting_mgr", jobDetails.getReporting_mgr());
		query.setParameter("team_lead", jobDetails.getTeam_lead());
		query.setParameter("curr_proj_id", jobDetails.getCurr_proj_id());
		query.setParameter("emp_code", jobDetails.getEmp_code());
		
		return (query.executeUpdate()>0);
	}

}

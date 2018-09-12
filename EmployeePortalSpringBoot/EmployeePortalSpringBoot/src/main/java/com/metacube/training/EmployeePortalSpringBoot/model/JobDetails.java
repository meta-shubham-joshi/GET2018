package com.metacube.training.EmployeePortalSpringBoot.model;

import java.util.Date;

public class JobDetails {

	private String job_detail_id;
	private String emp_code;
	private Date date_of_joining;
	private int total_exp;
	private int job_code;
	private String reporting_mgr;
	private String team_lead;
	private int curr_proj_id;

	public String getJob_detail_id() {
		return job_detail_id;
	}

	public void setJob_detail_id(String job_detail_id) {
		this.job_detail_id = job_detail_id;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public Date getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public int getTotal_exp() {
		return total_exp;
	}

	public void setTotal_exp(int total_exp) {
		this.total_exp = total_exp;
	}

	public int getJob_code() {
		return job_code;
	}

	public void setJob_code(int job_code) {
		this.job_code = job_code;
	}

	public String getReporting_mgr() {
		return reporting_mgr;
	}

	public void setReporting_mgr(String reporting_mgr) {
		this.reporting_mgr = reporting_mgr;
	}

	public String getTeam_lead() {
		return team_lead;
	}

	public void setTeam_lead(String team_lead) {
		this.team_lead = team_lead;
	}

	public int getCurr_proj_id() {
		return curr_proj_id;
	}

	public void setCurr_proj_id(int curr_proj_id) {
		this.curr_proj_id = curr_proj_id;
	}

}

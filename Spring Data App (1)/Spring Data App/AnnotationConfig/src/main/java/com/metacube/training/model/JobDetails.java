package com.metacube.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "job_detail")
public class JobDetails {

	@Id
	@Column(name = "job_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int job_detail_id;

	@Column(name = "emp_code")
	private String emp_code;

	@Column(name = "date_of_joining")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_of_joining;

	@Column(name = "total_exp")
	private int total_exp;

	@Column(name = "job_code")
	private int job_code;

	@Column(name = "reporting_mgr")
	private String reporting_mgr;

	@Column(name = "team_lead")
	private String team_lead;

	@Column(name = "curr_proj_id")
	private int curr_proj_id;

	public int getJob_detail_id() {
		return job_detail_id;
	}

	public void setJob_detail_id(int job_detail_id) {
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

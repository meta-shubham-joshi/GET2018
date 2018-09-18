package com.metacube.training.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.mappers.ValidateMapper;
import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployees() {
		// return jdbcTemplate.query(SELECT_QUERY, new EmployeeMapper());

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);

		List<Employee> employee = session.createQuery(criteria).getResultList();

		session.close();

		return employee;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		/*
		 * int id = (Integer)sessionFactory.getCurrentSession().save(employee);
		 * 
		 * System.out.println(id);
		 * 
		 * if(id>0){ return true; } return false;
		 */
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
		// Session session = sessionFactory.openSession();
		// Transaction tx = null;
		// try {
		// tx = session.beginTransaction();
		// session.save(employee);
		// tx.commit();
		// } catch (HibernateException e) {
		// if (tx != null)
		// tx.rollback();
		// e.printStackTrace();
		// return false;
		// } finally {
		// session.close();
		// }
		// return true;
	}

	/**
	 * Updated with updation of all fields instead of password update.
	 */
	@Override
	public boolean updateEmployeePasswordInDatabase(Employee employee) {
		// return jdbcTemplate.update(UPDATE_QUERY, employee.getFirstName(),
		// employee.getLastName(), employee.getDob(), employee.getGender(),
		// employee.getContactNumber() ,employee.getEmployeeID()) > 0;

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaUpdate<Employee> criteria = builder
				.createCriteriaUpdate(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.set(employeeRoot.get("firstName"), employee.getFirstName())
				.where(builder.equal(employeeRoot.get("emp_code"),
						employee.getEmpCode()));
		criteria.set(employeeRoot.get("lastName"), employee.getLastName())
				.where(builder.equal(employeeRoot.get("emp_code"),
						employee.getEmpCode()));
		criteria.set(employeeRoot.get("dob"), employee.getDob()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmpCode()));
		criteria.set(employeeRoot.get("gender"), employee.getGender()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmpCode()));
		criteria.set(employeeRoot.get("primary_contact_number"),
				employee.getPrimary_contact_number()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmpCode()));
		criteria.set(employeeRoot.get("secondary_contact_number"),
				employee.getPrimary_contact_number()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmpCode()));
		criteria.set(employeeRoot.get("email_id"), employee.getEmail_id())
				.where(builder.equal(employeeRoot.get("emp_code"),
						employee.getEmpCode()));
		criteria.set(employeeRoot.get("password"), employee.getPassword())
				.where(builder.equal(employeeRoot.get("emp_code"),
						employee.getEmpCode()));

		try {
			tx = session.beginTransaction();
			session.createQuery(criteria).executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean delete(Employee employee) {
		// return jdbcTemplate.update(DELETE_QUERY, employee.getEmployeeID()) >
		// 0;

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaDelete<Employee> criteria = builder
				.createCriteriaDelete(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.where(builder.equal(employeeRoot.get("emp_code"),
				employee.getEmpCode()));

		try {
			tx = session.beginTransaction();
			session.createQuery(criteria).executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}

		return true;

	}

	@Override
	public Employee getEmployeeDetailsByEmpCode(String empCode) {
		
		try {
			Session session = sessionFactory.openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Employee> criteria = builder
					.createQuery(Employee.class);
			Root<Employee> employeeRoot = criteria.from(Employee.class);
			criteria.select(employeeRoot);
			criteria.where(builder.equal(employeeRoot.get("empCode"), empCode));

			Employee employee = session.createQuery(criteria).getSingleResult();

			session.close();

			return employee;
		} catch (NoResultException nre) {

			nre.printStackTrace();
			Employee employee = new Employee();
			employee.setEmpCode(empCode);
			return employee;
		}

	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		// return jdbcTemplate.query(SELECT_BY_NAME_QUERY, new Object[] {name},
		// new EmployeeMapper());

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		criteria.where(builder.equal(employeeRoot.get("firstName"), name));

		List<Employee> employee = session.createQuery(criteria).getResultList();

		session.close();

		return employee;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		// return jdbcTemplate.queryForObject(GET_ID_BY_EMAIL, new Object[]
		// {email}, new EmployeeMapper());

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		criteria.where(builder.equal(employeeRoot.get("email_id"), email));

		Employee employee = (Employee) session.createQuery(criteria)
				.getSingleResult();

		session.close();

		return employee;

	}

	@Override
	public Employee validateCredentials(String emp_code) {

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		criteria.where(builder.equal(employeeRoot.get("empCode"), emp_code));

		Employee employee = (Employee) session.createQuery(criteria)
				.getSingleResult();

		session.close();

		return employee;
	}

	@Override
	public Employee getLastEmployeeAdded() {

		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.orderBy(builder.desc(employeeRoot.get("empCode")));
		Query<Employee> query = session.createQuery(criteria).setMaxResults(1);
		Employee employee = query.getSingleResult();
		session.close();
		return employee;
	}

}

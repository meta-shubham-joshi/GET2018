package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.mappers.SkillMapper;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO {

	@Autowired
	   private SessionFactory sessionFactory;

	private final String SQL_FIND_SKILL = "from Skill where  skill_id  = :skill_id";
	private final String SQL_DELETE_SKILL = "delete from Skill where skill_id = :skill_id";
	private final String SQL_GET_ALL = "from Skill";
	
	@Override
	public Skill getSkillById(int id) {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery(SQL_FIND_SKILL);
		query.setParameter("skill_id", id);
		return query.getSingleResult();
	}

	@Override
	public boolean deleteSkill(Skill skill) {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery(SQL_DELETE_SKILL);
		query.setParameter("skill_id", skill.getId());
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean addSkills(Skill skill) {
		int id = (Integer)sessionFactory.getCurrentSession().save(skill);
		System.out.println(id);
		
		if(id>0)
		return true;
		
		return false;
	}

	@Override
	public List<Skill> getAllSkills() {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery(SQL_GET_ALL);
		return query.getResultList();
	}

}

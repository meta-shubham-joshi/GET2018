package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public interface SkillRepository<S> extends JpaRepository<Skill, Integer> {

}

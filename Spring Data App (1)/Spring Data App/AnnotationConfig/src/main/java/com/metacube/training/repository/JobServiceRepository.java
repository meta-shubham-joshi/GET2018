package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Job;
import com.metacube.training.model.Project;

@Repository
@Transactional
public interface JobServiceRepository<J> extends JpaRepository<Job, Integer> {

}

package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.ProjectDao;
import com.endava.jpa.model.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Project find(int id) {
		return null;
	}

	public List<Project> find(String projectName) {
		return null;
	}

	public void save(Project toBeSaved) {

	}

	public void update(Project toBeUpdated) {

	}

	public void remove(Project toBeRemoved) {

	}
}

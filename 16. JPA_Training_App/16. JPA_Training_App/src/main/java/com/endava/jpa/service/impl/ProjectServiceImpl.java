package com.endava.jpa.service.impl;

import com.endava.jpa.model.Project;
import com.endava.jpa.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

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

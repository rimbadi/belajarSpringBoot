package com.example.demo.services;

import com.example.demo.models.Project;

import java.util.List;

public interface ProjectsServices {
    public List<Project> getAll();

    public Project getById(Integer id);

    public Boolean save(Project project);

    public Boolean delete(Integer id);
}

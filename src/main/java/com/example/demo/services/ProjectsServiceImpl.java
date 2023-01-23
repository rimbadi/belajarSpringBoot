package com.example.demo.services;

import com.example.demo.models.Project;
import com.example.demo.repo.ProjectsRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsServiceImpl implements ProjectsServices{
    @Autowired
    private ProjectsRepository projectsRepository;


    @Override
    public List<Project> getAll(){
        return projectsRepository.findAll();
    }

    @Override
    public Project getById(Integer id) {
        return projectsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Project not found"));
    }

    @Override
    public Boolean delete(Integer id){
        projectsRepository.deleteById(id);
        return !projectsRepository.findById(id).isPresent();
    }

    @Override
    public Boolean save(Project project){
        projectsRepository.save(project);
        return projectsRepository.findById(project.getId()).isPresent();
    }
}

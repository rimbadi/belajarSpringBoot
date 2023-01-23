package com.example.demo.repo;

import com.example.demo.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Project, Integer> {

}

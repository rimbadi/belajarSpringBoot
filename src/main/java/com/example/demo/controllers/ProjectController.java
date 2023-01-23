package com.example.demo.controllers;

import com.example.demo.models.Project;
import com.example.demo.services.ProjectsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("projects")
public class ProjectController {
    @Autowired
    private ProjectsServices projectsServices;

    @GetMapping
    public String index(Model model){
        model.addAttribute("projects", projectsServices.getAll());
        return "project/project-index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(@PathVariable(required = false) Integer id, Model model){
        if (id !=null){
            model.addAttribute("projects", projectsServices.getById(id));
        }else {
            model.addAttribute("projects", new Project());
        }
        return "project/form";
    }

    @PostMapping("save")
    public String save(@Nullable Project project){
        Boolean result;
        if (project.getId() != null){
            result = projectsServices.save(project);
        } else {
            result = projectsServices.save(project);
        }
        if (result){
            return "redirect:/project";
        }else {
            return "project/form";
        }
    }

    @PostMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id){
        Boolean result = projectsServices.delete(id);
        if (result){
            return "redirect:/project";
        }else {
            return "";
        }
    }
}

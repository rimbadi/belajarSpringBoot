package com.example.demo.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "projects")
public class Project {
    @Id
    @Column(name = "idprojects")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "projects")
    private List<Project> projects;

    @Column(name = "name")
    private String name;

    @Column(name = "tech")
    private String tech;

    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private String picture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

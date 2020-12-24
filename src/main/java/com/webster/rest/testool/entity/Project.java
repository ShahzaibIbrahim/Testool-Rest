package com.webster.rest.testool.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="Project")
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="project_id")
    private int id;

    @Column(name="project_name")
    @NotNull
    private String projectName;

    public Project() {
    }

    public Project(int id, String projectName) {
        this.id = id;
        this.projectName = projectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}

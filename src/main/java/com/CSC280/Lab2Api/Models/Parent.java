package com.CSC280.Lab2Api.Models;

import com.CSC280.Lab2Api.Controllers.Repos.ParentRepo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Parent {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade =  CascadeType.ALL)
    private List<Student> studentList = null;

    public Parent(){}
    public Parent(String name) {
        this.name = name;
    }

}

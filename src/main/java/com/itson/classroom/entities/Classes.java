/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.classroom.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classes {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String name;
    private String student;
    private Assigment assigment;
    
    private int id;
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Assigment getAssigment() {
        return assigment;
    }

    public void setAssigment(Assigment assigment) {
        this.assigment = assigment;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.classroom.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author ramon
 */
@Entity
public class Work {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the file_name
     */
    public String getFile_name() {
        return file_name;
    }

    /**
     * @param file_name the file_name to set
     */
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    /**
     * @return the id_student
     */
    public Student getId_student() {
        return id_student;
    }

    /**
     * @param id_student the id_student to set
     */
    public void setId_student(Student id_student) {
        this.id_student = id_student;
    }

    /**
     * @return the id_assignment
     */
    public Assignment getId_assignment() {
        return id_assignment;
    }

    /**
     * @param id_assignment the id_assignment to set
     */
    public void setId_assignment(Assignment id_assignment) {
        this.id_assignment = id_assignment;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String file_name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_student")
    private Student id_student;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_assignment")
    private Assignment id_assignment;

   
}

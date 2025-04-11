/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.classroom.persistence;

import com.itson.classroom.entities.Student;
import com.itson.classroom.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

/**
 *
 * @author ramon
 */
public class StudentDAO {
    
    public static List<Student> getAll(){
        List<Student> students = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            CriteriaQuery<Student> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Student.class);
            criteriaQuery.from(Student.class);
            
            students = session.createQuery(criteriaQuery).getResultList();
        } catch(Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return students;
    }
    
    public static boolean save(Student s){
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.save(s);
            session.getTransaction().commit();
            
            resultado = s.getId() !=0;
            
        } catch (Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    public static boolean delete(Student s){
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.delete(s);
            session.getTransaction().commit();
            
            resultado = s.getId() !=0;
            
        } catch (Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
}

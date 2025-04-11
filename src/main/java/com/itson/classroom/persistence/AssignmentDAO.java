/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.classroom.persistence;

import com.itson.classroom.entities.Assignment;
import com.itson.classroom.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

/**
 *
 * @author ramon
 */
public class AssignmentDAO {
    
    public static List<Assignment> getAll(){
        List<Assignment> assigments = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            CriteriaQuery<Assignment> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Assignment.class);
            criteriaQuery.from(Assignment.class);
            
            assigments = session.createQuery(criteriaQuery).getResultList();
        } catch(Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return assigments;
    }
    
    public static boolean save(Assignment a){
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.save(a);
            session.getTransaction().commit();
            
            resultado = a.getId() !=0;
            
        } catch (Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    public static boolean update(Assignment a){
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.update(a);
            session.getTransaction().commit();
            
            resultado = a.getId() !=0;
            
        } catch (Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    public static boolean delete(Assignment a){
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.delete(a);
            session.getTransaction().commit();
            
            resultado = a.getId() !=0;
            
        } catch (Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
}

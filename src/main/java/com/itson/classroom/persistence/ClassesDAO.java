/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.classroom.persistence;

import com.itson.classroom.entities.Classes;
import com.itson.classroom.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

/**
 *
 * @author ramon
 */
public class ClassesDAO {
    
    public static List<Classes> getAll(){
        List<Classes> classes = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            CriteriaQuery<Classes> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Classes.class);
            criteriaQuery.from(Classes.class);
            
            classes = session.createQuery(criteriaQuery).getResultList();
        } catch(Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return classes;
    }
    
    public static boolean save(Classes c){
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.save(c);
            session.getTransaction().commit();
            
            resultado = c.getId() !=0;
            
        } catch (Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    public static boolean update(Classes c){
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.update(c);
            session.getTransaction().commit();
            
            resultado = c.getId() !=0;
            
        } catch (Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    public static boolean delete(Classes c){
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.delete(c);
            session.getTransaction().commit();
            
            resultado = c.getId() !=0;
            
        } catch (Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
}

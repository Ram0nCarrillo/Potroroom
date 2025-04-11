/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.classroom.persistence;

import com.itson.classroom.entities.Assigment;
import com.itson.classroom.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

/**
 *
 * @author ramon
 */
public class AssigmentDAO {
    
    public static List<Assigment> getAll(){
        List<Assigment> assigments = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            CriteriaQuery<Assigment> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Assigment.class);
            criteriaQuery.from(Assigment.class);
            
            assigments = session.createQuery(criteriaQuery).getResultList();
        } catch(Exception ex){
            System.out.println("Ocurrio un error: " + ex.getMessage());
        }
        return assigments;
    }
    
    public static Assigment getById(int id) {
        Assigment assignment = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            assignment = session.get(Assigment.class, id); // ← Hibernate busca por ID
            session.close();
        } catch (Exception ex) {
            System.out.println("Error al obtener el Assigment: " + ex.getMessage());
        }
        return assignment;
    }

    
    public static boolean save(Assigment a){
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
    
    public static boolean update(Assigment a){
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
    
    public static boolean delete(Assigment a){
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

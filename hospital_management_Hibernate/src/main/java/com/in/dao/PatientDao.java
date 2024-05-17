package com.in.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.in.Entity.Patient;
import com.in.utility.HibernateUtil;

public class PatientDao {
		
    public void savePatient(Patient patient) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List<Patient> getPatients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Patient", Patient.class).list();
        }
    }
    
    public void updatePatient(int id, String name, int age) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "update Patient set name = :name, age = :age where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            query.setParameter("age", age);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            if (result > 0) {
                System.out.println("Patient was updated successfully.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deletePatient(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "delete from Patient where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            if (result > 0) {
                System.out.println("Patient was deleted successfully.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
	


package com.in.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.in.Entity.Doctor;
import com.in.utility.HibernateUtil;

public class DoctorDao {

	  public void saveDoctor(Doctor doctor) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(doctor);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    public List<Doctor> getDoctors() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Doctor", Doctor.class).list();
	        }
	    }

	    public void updateDoctor(int id, String name, String specialty) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            String hql = "update Doctor set name = :name, specialty = :specialty where id = :id";
	            Query query = session.createQuery(hql);
	            query.setParameter("name", name);
	            query.setParameter("specialty", specialty);
	            query.setParameter("id", id);
	            int result = query.executeUpdate();
	            if (result > 0) {
	                System.out.println("Doctor was updated successfully.");
	            }
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    public void deleteDoctor(int id) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            String hql = "delete from Doctor where id = :id";
	            Query query = session.createQuery(hql);
	            query.setParameter("id", id);
	            int result = query.executeUpdate();
	            if (result > 0) {
	                System.out.println("Doctor was deleted successfully.");
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

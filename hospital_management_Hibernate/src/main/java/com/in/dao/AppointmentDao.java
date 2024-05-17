package com.in.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.in.Entity.Appointment;
import com.in.Entity.Doctor;
import com.in.Entity.Patient;
import com.in.utility.HibernateUtil;

public class AppointmentDao {
	public void saveAppointment(Appointment appointment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Appointment> getAppointments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Appointment", Appointment.class).list();
        }
    }

    public void updateAppointment(int id, Patient patient, Doctor doctor, Date appointmentDate) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "update Appointment set patient = :patient, doctor = :doctor, appointmentDate = :appointmentDate where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("patient", patient);
            query.setParameter("doctor", doctor);
            query.setParameter("appointmentDate", appointmentDate);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            if (result > 0) {
                System.out.println("Appointment was updated successfully.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAppointment(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "delete from Appointment where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            if (result > 0) {
                System.out.println("Appointment was deleted successfully.");
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

package com.in.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDate;

	public Appointment(int id, Patient patient, Doctor doctor, Date appointmentDate) {
		super();
		this.id = id;
		this.patient = patient;
		this.doctor = doctor;
		this.appointmentDate = appointmentDate;
	}

	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}



	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", appointmentDate="
				+ appointmentDate + "]";
	}
    
    
}

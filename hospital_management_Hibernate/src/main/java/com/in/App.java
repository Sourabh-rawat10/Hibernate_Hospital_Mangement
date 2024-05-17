package com.in;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.in.Entity.Appointment;
import com.in.Entity.Doctor;
import com.in.Entity.Patient;
import com.in.dao.AppointmentDao;
import com.in.dao.DoctorDao;
import com.in.dao.PatientDao;

/**
 * Hello world!
 *
 */
public class App 
{
	  public static Scanner scanner = new Scanner(System.in);
	  public static PatientDao patientDAO = new PatientDao();
	  public static DoctorDao doctorDAO = new DoctorDao();
	  public static AppointmentDao  appointmentDAO = new AppointmentDao();
      
	public static void savePatient() {
		 System.out.println("Enter patient name:");
         String patientName = scanner.nextLine();
         System.out.println("Enter patient age:");
         int patientAge = scanner.nextInt();
         scanner.nextLine();  

         Patient newPatient = new Patient();
         newPatient.setName(patientName);
         newPatient.setAge(patientAge);
         patientDAO.savePatient(newPatient);
         System.out.println("Patient added successfully.");

	}
	
	public static void getAllPatient() {
		List<Patient> patients = patientDAO.getPatients();
        for (Patient patient : patients) {
            System.out.println(patient);
        }
	}
	
	public static void updatePatient() {
        System.out.println("Enter patient ID to update:");
        int updatePatientId = scanner.nextInt();
        scanner.nextLine();  
        System.out.println("Enter new patient name:");
        String updatePatientName = scanner.nextLine();
        System.out.println("Enter new patient age:");
        int updatePatientAge = scanner.nextInt();
        scanner.nextLine();  

        patientDAO.updatePatient(updatePatientId, updatePatientName, updatePatientAge);
        System.out.println("Patient updated successfully.");
	}
	
	public static void deletePatient() {
        System.out.println("Enter patient ID to delete:");
        int deletePatientId = scanner.nextInt();
        scanner.nextLine();  
        patientDAO.deletePatient(deletePatientId);
        System.out.println("Patient deleted successfully.");

	}
	
	public static void saveDoctor() {
		 System.out.println("Enter doctor name:");
         String doctorName = scanner.nextLine();
         System.out.println("Enter doctor specialty:");
         String doctorSpecialty = scanner.nextLine();

         Doctor newDoctor = new Doctor();
         newDoctor.setName(doctorName);
         newDoctor.setSpecialty(doctorSpecialty);
         doctorDAO.saveDoctor(newDoctor);
         System.out.println("Doctor added successfully.");
	}
	
	public static void getAllDoctor() {
        List<Doctor> doctors = doctorDAO.getDoctors();
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
	}
	
	public static void updateDoctor() {
		 System.out.println("Enter doctor ID to update:");
         int updateDoctorId = scanner.nextInt();
         scanner.nextLine(); 
         System.out.println("Enter new doctor name:");
         String updateDoctorName = scanner.nextLine();
         System.out.println("Enter new doctor specialty:");
         String updateDoctorSpecialty = scanner.nextLine();

         doctorDAO.updateDoctor(updateDoctorId, updateDoctorName, updateDoctorSpecialty);
         System.out.println("Doctor updated successfully.");
	}
	
	public static void deleteDoctor() {
        System.out.println("Enter doctor ID to delete:");
        int deleteDoctorId = scanner.nextInt();
        scanner.nextLine();  
        doctorDAO.deleteDoctor(deleteDoctorId);
        System.out.println("Doctor deleted successfully.");
	}
	
	
	public static void saveAppointment() {
		 System.out.println("Enter patient ID for appointment:");
         int appointmentPatientId = scanner.nextInt();
         scanner.nextLine();  
         System.out.println("Enter doctor ID for appointment:");
         int appointmentDoctorId = scanner.nextInt();
         scanner.nextLine();  
         System.out.println("Enter appointment date (yyyy-MM-dd):");
         String appointmentDateStr = scanner.nextLine();
         Date appointmentDate = java.sql.Date.valueOf(appointmentDateStr);

         Patient appointmentPatient = patientDAO.getPatients().stream()
                 .filter(p -> p.getId() == appointmentPatientId)
                 .findFirst().orElse(null);
         Doctor appointmentDoctor = doctorDAO.getDoctors().stream()
                 .filter(d -> d.getId() == appointmentDoctorId)
                 .findFirst().orElse(null);

         if (appointmentPatient != null && appointmentDoctor != null) {
             Appointment newAppointment = new Appointment();
             newAppointment.setPatient(appointmentPatient);
             newAppointment.setDoctor(appointmentDoctor);
             newAppointment.setAppointmentDate(appointmentDate);
             appointmentDAO.saveAppointment(newAppointment);
             System.out.println("Appointment added successfully.");
         } else {
             System.out.println("Invalid patient or doctor ID.");
         }
	}
	
	public static void getAllAppointment() {
		  List<Appointment> appointments = appointmentDAO.getAppointments();
          for (Appointment appointment : appointments) {
              System.out.println(appointment);
          }
	}
	
	public static void updateAppointment() {
		 System.out.println("Enter appointment ID to update:");
         int updateAppointmentId = scanner.nextInt();
         scanner.nextLine(); 
         System.out.println("Enter new patient ID:");
         int updateAppointmentPatientId = scanner.nextInt();
         scanner.nextLine(); 
         System.out.println("Enter new doctor ID:");
         int updateAppointmentDoctorId = scanner.nextInt();
         scanner.nextLine(); 
         System.out.println("Enter new appointment date (yyyy-MM-dd):");
         String updateAppointmentDateStr = scanner.nextLine();
         Date updateAppointmentDate = java.sql.Date.valueOf(updateAppointmentDateStr);

         Patient updateAppointmentPatient = patientDAO.getPatients().stream()
                 .filter(p -> p.getId() == updateAppointmentPatientId)
                 .findFirst().orElse(null);
         Doctor updateAppointmentDoctor = doctorDAO.getDoctors().stream()
                 .filter(d -> d.getId() == updateAppointmentDoctorId)
                 .findFirst().orElse(null);

         if (updateAppointmentPatient != null && updateAppointmentDoctor != null) {
             Appointment updateAppointment = new Appointment();
             updateAppointment.setId(updateAppointmentId);
             updateAppointment.setPatient(updateAppointmentPatient);
             updateAppointment.setDoctor(updateAppointmentDoctor);
             updateAppointment.setAppointmentDate(updateAppointmentDate);
             appointmentDAO.updateAppointment(updateAppointmentId, updateAppointmentPatient, updateAppointmentDoctor, updateAppointmentDate);
             System.out.println("Appointment updated successfully.");
         } else {
             System.out.println("Invalid patient or doctor ID.");
         }
	}
	
	public static void deleteAppointment() {
        System.out.println("Enter appointment ID to delete:");
        int deleteAppointmentId = scanner.nextInt();
        scanner.nextLine();  
        appointmentDAO.deleteAppointment(deleteAppointmentId);
        System.out.println("Appointment deleted successfully.");
	}
	
	
    public static void main( String[] args )
    {


          while (true) {
              System.out.println("\nChoose an option:");
              System.out.println("1. Add Patient");
              System.out.println("2. View Patients");
              System.out.println("3. Update Patient");
              System.out.println("4. Delete Patient");
              System.out.println("5. Add Doctor");
              System.out.println("6. View Doctors");
              System.out.println("7. Update Doctor");
              System.out.println("8. Delete Doctor");
              System.out.println("9. Add Appointment");
              System.out.println("10. View Appointments");
              System.out.println("11. Update Appointment");
              System.out.println("12. Delete Appointment");
              System.out.println("13. Exit");

              int choice = scanner.nextInt();
              scanner.nextLine();  // Consume newline

              switch (choice) {
                  case 1:
                     savePatient();
                     break;
                  case 2:
                      getAllPatient();
                      break;

                  case 3:
                	  updatePatient();
                      break;

                  case 4:
                	  deletePatient();
                	  break;

                  case 5:
                     saveDoctor();
                      break;

                  case 6:
                	  getAllDoctor();
                      break;

                  case 7:
                     updateDoctor();
                      break;

                  case 8:
                	  deleteDoctor();
                	  break;
                  case 9:
                     saveAppointment();
                      break;

                  case 10:
                    getAllAppointment();
                      break;

                  case 11:
                     updateAppointment();
                      break;

                  case 12:
                	  deleteAppointment();
                      break;

                  case 13:
                      scanner.close();
                      System.out.println("Exiting...");
                      System.exit(0);
                      break;

                  default:
                      System.out.println("Invalid option. Please try again.");
                      break;
              }
          }
    }
}

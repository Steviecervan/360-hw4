package hw4;

import java.util.ArrayList;

public class Database {
	private ArrayList<Patient> patients;
	
	public Database() {
		 patients = new ArrayList<Patient>();
	}
	
	public void addPatientToDB(Patient targetPatient) {
		if(!patients.contains(targetPatient)) {
			System.out.println("Patient does not exist. Added!");
			patients.add(targetPatient);			
		}else {
			System.out.println("Patient does exist. Not Added!");
		}
	}
	
	public boolean searchForPatientID(int targetPatientID) {
		for(Patient patient : patients) {
			if(patient.getPatientID() == targetPatientID) {
				return true;
			}
		}
		
		return false;
	}
	
	public Patient getPatient(int targetPatientID) {
		for(Patient patient : patients) {
			if(patient.getPatientID() == targetPatientID) {
				return patient;
			}
		}
		
		return null;
	}
}

package hw4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {
	private FileOutputStream fileStream;
	private PrintWriter outFile;
	private FileInputStream fileInput;
	private Scanner fileReader;
	
	public FileManager(){	
		System.out.println("File Manager Created");
	}
	
	//	Creates the patient info text file
	public void createNewPatientFile(Patient patient) throws IOException {
		//	Create the patient file name
		String fileName = Integer.toString(patient.getPatientID()) + "_PatientInfo.txt";
		
		//	Create and open the the stream
		fileStream = new FileOutputStream(fileName);
		outFile = new PrintWriter(fileStream);
		
		//	patientID_PatientInfo.txt Format:
		/*	PatientID
		 * 	first name
		 * 	last name
		 * 	email
		 * 	phoneNumber
		 * 	healthHistory
		 * 	insuranceID 
		 */
		
		//	Write the patient information to the file location
		outFile.println(patient.getPatientID());
		outFile.println(patient.getPatientForm().getFirstName());
		outFile.println(patient.getPatientForm().getLastName());
		outFile.println(patient.getPatientForm().getEmail());
		outFile.println(patient.getPatientForm().getPhoneNumber());
		outFile.println(patient.getPatientForm().getHealthHistory());
		outFile.println(patient.getPatientForm().getInsuranceID());
		
		//	Close the PrintWriter
		outFile.close();
	}
	
	public void createNewPatientScanFile(Patient patient) throws IOException{
		//	Create the scan file name
		String fileName = Integer.toString(patient.getPatientID()) + "CTResults.txt";
		
		//	Create and open the stream
		fileStream = new FileOutputStream(fileName);
		outFile = new PrintWriter(fileStream);
		
		//	patientIDCTResults.txt Format:
		/*	total agatston score
		 * 	lm score
		 * 	lad score
		 * 	lcx score
		 * 	rca score
		 * 	pda score
		 */
		
		//	Write the patient information to the file location
		outFile.println(patient.getPatientScan().getTotalAgatstonScore());
		outFile.println(patient.getPatientScan().getLMScore());
		outFile.println(patient.getPatientScan().getLADScore());
		outFile.println(patient.getPatientScan().getLCXScore());
		outFile.println(patient.getPatientScan().getRCAScore());
		outFile.println(patient.getPatientScan().getPDAScore());
		
		//	Close the PrintWriter
		outFile.close();
	}
}

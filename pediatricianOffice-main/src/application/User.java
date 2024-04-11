package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
	//write new file for doctor info
	void writeDocFile(String fn, String ln, LocalDate DOB) {
		File docFile = new File("Doc" + fn + ln + DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ".txt");
		Writer writer;
		try {
			writer = new FileWriter(docFile);
			String docInfo = fn + "\n" + ln + "\n" + DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			writer.write(docInfo);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//check if doc alr exists to login
	boolean docExists(String fn, String ln, LocalDate DOB) {
		File docFile = new File("Doc" + fn + ln+ DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ".txt");
		return docFile.exists();
	}
	
	//write new file for nurse info
	void writeNurseFile(String fn, String ln, LocalDate DOB) {
		File nFile = new File("Nurse" + fn + ln + DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ".txt");
		Writer writer;
		try {
			writer = new FileWriter(nFile);
			String nInfo = fn + "\n" + ln + "\n" + DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			writer.write(nInfo);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//check if nurse alr exists to login
	boolean nurseExists(String fn, String ln, LocalDate DOB) {
		File nFile = new File("Nurse" + fn + ln+ DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ".txt");
		return nFile.exists();
	}
	
	//write patient intake file after nurse puts in info
	void writePatientIntake(String fn, String ln, LocalDate DOB, String age, String height, String weight, String bp, String temp, String allergies, String meds, String history) {
		File pFile = new File("Patient" + fn + ln + DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "Intake.txt");
		Writer writer;
		try {
			writer = new FileWriter(pFile);
			String pInfo = age + "\n" + height + "\n" + weight + "\n" + bp + "\n" + temp + "\n" + allergies + "\n" + meds + "\n" + history;
			writer.write(pInfo);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//write patient physical file after doctor puts in info
	void writePatientPhys(String fn, String ln, LocalDate DOB, String testResults, String prescription) {
		File pFile = new File("Patient" + fn + ln + DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "Physical.txt");
		Writer writer;
		try {
			writer = new FileWriter(pFile);
			String pInfo = testResults + "\n" + prescription;
			writer.write(pInfo);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//write patient acc file
	void writePatientFile(String fn, String ln, LocalDate DOB) {
		File pFile = new File("Patient" + fn + ln + DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ".txt");
		Writer writer;
		try {
			writer = new FileWriter(pFile);
			String pInfo = fn + "\n " + ln + "\n" + DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			writer.write(pInfo);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//check if patient alr exists to login
	boolean patientExists(String fn, String ln, LocalDate DOB) {
		File inFile = new File("Patient" + fn + ln+ DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "Intake.txt");
		File physFile = new File("Patient" + fn + ln+ DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "Physical.txt");
		return physFile.exists() && inFile.exists();
	}
}

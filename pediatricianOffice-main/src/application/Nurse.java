package application;

public class Nurse {
	String fName, lName;
	int DOB;
	
	public void addNurse(String fn, String ln, int dob) {
		fName = fn;
		lName = ln;
		DOB = dob;
	}
	
	public boolean nurseExists(String fn, String ln, int dob) {
		return false;
	}
}

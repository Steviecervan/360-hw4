package hw4;

public class Patient {
	private Form pForm;
	private Scan pScan;
	private int patientID;
	
	public Patient(Form form) {
		this.pForm = form;
		this.patientID = makePatientID();
	}
	
	private int makePatientID() {
		//	5 Digit unique patient ID
		int id = 0;
		
		for(int i = 0; i < pForm.getFirstName().length(); i++) {
			id += pForm.getFirstName().charAt(i) * 100;
		}
		
		//	String ID -> Int ID
		String strID = Integer.toString(id).substring(0, 5);
		id = Integer.valueOf(strID);
		
		return id;
	}
	
	public boolean setScan(Scan visitScan) {
		this.pScan = visitScan;
		return true;
	}
	
	public int getPatientID() {
		return this.patientID;
	}
	
	public Form getPatientForm() {
		return pForm;
	}
	
	public Scan getPatientScan() {
		return pScan;
	}
}

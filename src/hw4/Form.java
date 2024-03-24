package hw4;

public class Form {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String healthHistory;
	private String insuranceID;
	
	Form(String firstName, String lastName, String email, String phoneNumber, String healthHistory, String insuranceID){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.healthHistory = healthHistory;
		this.insuranceID = insuranceID;
	}
	
	//	Setters
	public boolean setFirstName(String firstName) {
		this.firstName = firstName;
		return true;
	}
	
	public boolean setLastName(String lastName) {
		this.lastName = lastName;
		return true;
	}
	
	public boolean setEmail(String email) {
		this.email = email;
		return true;
	}
	
	public boolean setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return true;
	}
	
	public boolean setHealthHistory(String healthHistory) {
		this.healthHistory = healthHistory;
		return true;
	}
	
	public boolean setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
		return true;
	}
	
	//	Getters
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getHealthHistory() {
		return this.healthHistory;
	}
	
	public String getInsuranceID() {
		return this.insuranceID;
	}
}

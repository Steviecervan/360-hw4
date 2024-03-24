package hw4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PatientIntakeWindow extends Screen{
	public PatientIntakeWindow() {		
		//	Layout Elements
		GridPane inputGrid = new GridPane();
		inputGrid.setAlignment(Pos.CENTER);
		inputGrid.setVgap(8.0);
		inputGrid.setHgap(35.0);
		
		VBox windowVBox = new VBox();
		windowVBox.setSpacing(25.0);
		windowVBox.setAlignment(Pos.CENTER);
		
		//	Necessary Elements
		Label windowHeader = new Label("Patient Intake Form");
		Label firstNameLabel = new Label("First name:");
		Label lastNameLabel = new Label("Last name:");
		Label emailLabel = new Label("Email:");
		Label phoneNumberLabel = new Label("Phone Number:");
		Label healthHistoryLabel = new Label("Health History:");
		Label insuranceLabel = new Label("Insurance ID:");
		
		TextField firstNameTF = new TextField();
		TextField lastNameTF = new TextField();
		TextField emailTF = new TextField();
		TextField phoneNumberTF = new TextField();
		TextField healthHistoryTF = new TextField();
		TextField insuranceTF = new TextField();
		
		Button saveButton = new Button("Save");
		saveButton.setPrefSize(75.0, 27.0);
		
		//	Save patient information to file system
		saveButton.setOnAction(new EventHandler<>() {
			public void handle(ActionEvent event) {
				System.out.println("Create form and patient with said form");
				
				//	Gather the information from the text fields
				String pFirstName = firstNameTF.getText();
				String pLastName = lastNameTF.getText();
				String pEmail = emailTF.getText();
				String pPhoneNumber = phoneNumberTF.getText();
				String pHealthHistory = healthHistoryTF.getText();
				String pInsurance = insuranceTF.getText();
				
				//	Create form object
				Form newPatientForm = new Form(pFirstName, pLastName, pEmail, pPhoneNumber, pHealthHistory, pInsurance);		
				
				//	Create new patient with form
				Patient newPatient = new Patient(newPatientForm);
				
				//	Save patient to database
				SystemControl.database.addPatientToDB(newPatient);
				
				//	Create txt file with all patient information
				try {
					SystemControl.fileManager.createNewPatientFile(newPatient);					
				}catch(Exception e) {
					System.out.println("ERROR");
				}
				
				//	Clear the text fields for future use
				firstNameTF.clear();
				lastNameTF.clear();
				emailTF.clear();
				phoneNumberTF.clear();
				healthHistoryTF.clear();
				insuranceTF.clear();
				
				//	Navigate to the main screen
				SystemControl.screenNav.setMainView();
			}
		});
		
		//	Add elements to Gridpane
		inputGrid.add(firstNameLabel, 0, 0);
		inputGrid.add(firstNameTF, 1, 0);
		inputGrid.add(lastNameLabel, 0, 1);
		inputGrid.add(lastNameTF, 1, 1);
		inputGrid.add(emailLabel, 0, 2);
		inputGrid.add(emailTF, 1, 2);
		inputGrid.add(phoneNumberLabel, 0, 3);
		inputGrid.add(phoneNumberTF, 1, 3);
		inputGrid.add(healthHistoryLabel, 0, 4);
		inputGrid.add(healthHistoryTF, 1, 4);
		inputGrid.add(insuranceLabel, 0, 5);
		inputGrid.add(insuranceTF, 1, 5);
		
		//	Add all elements to windowVBox
		windowVBox.getChildren().addAll(windowHeader, inputGrid, saveButton);
	
		//	Add windowVBox (which contains all elements) to the windowRoot
		windowRoot.getChildren().add(windowVBox);
	}
}

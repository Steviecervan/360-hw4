package hw4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PatientUserInputWindow extends Screen{
	private Patient currPatient;
	
	public PatientUserInputWindow() {
		//	Layout elements
		VBox windowVBox = new VBox();
		windowVBox.setSpacing(20.0);
		windowVBox.setAlignment(Pos.CENTER);
		windowVBox.setPadding(new Insets(25, 25, 25, 25));
		
		//	Necessary elements
		Label windowHeaderLabel = new Label("Patient Login");
		Label instrLabel = new Label("Please enter Patient ID");
		TextField patientIDTF = new TextField();
		Button loginButton = new Button("Login");
		Label errorLabel = new Label();

		loginButton.setOnAction(new EventHandler<>() {
			public void handle(ActionEvent event) {
				System.out.println("Check database for patient id");
				
				//	Collect patient id from text field
				int patientId = Integer.valueOf(patientIDTF.getText());
				
				//	Check database for patient
				if(SystemControl.database.searchForPatientID(patientId)) {
					currPatient = SystemControl.database.getPatient(patientId);
					
					//	Navigate to the main screen
					SystemControl.screenNav.setScreenPatientView(currPatient);

				}else {
					//	Display an error message
					errorLabel.setText("ERROR: Unable to find patient");
				}
				
			}
		});
		
		
		windowVBox.getChildren().addAll(windowHeaderLabel, instrLabel, patientIDTF, loginButton, errorLabel);
		windowRoot.getChildren().add(windowVBox);
	}
}

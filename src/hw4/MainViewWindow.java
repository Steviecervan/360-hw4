package hw4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainViewWindow extends Screen{		
	public MainViewWindow() {
		//	Layout Elements
		VBox windowVBox = new VBox();
		windowVBox.setSpacing(20.0);
		windowVBox.setAlignment(Pos.CENTER);
		
		//	Necessary Elements
		Label windowHeader = new Label("Welcome to Heart Health Imaging and Recording System");
		
		Button patientIntakeButton = new Button("Patient Intake");
		patientIntakeButton.setPrefWidth(200.0);
		patientIntakeButton.setPrefHeight(45.0);
		
		Button techScanButton = new Button("CT Scan Tech View");
		techScanButton.setPrefWidth(200.0);
		techScanButton.setPrefHeight(45.0);
		
		Button patientViewButton = new Button("Patient View");
		patientViewButton.setPrefWidth(200.0);
		patientViewButton.setPrefHeight(45.0);
		
		//	Add elements to the layout elements
		windowVBox.getChildren().addAll(windowHeader, patientIntakeButton, techScanButton, patientViewButton);
	
		//	Add windowVBox (which contains all elements) to the windowRoot
		windowRoot.getChildren().add(windowVBox);
		
		//	Adding button handler events
		patientIntakeButton.setOnAction(new EventHandler<>() {
			public void handle(ActionEvent event) {
				System.out.println("Go to patient intake form");
				
				//	Navigate to patient intake form
				SystemControl.screenNav.setScreenPatientIntake();
			}
		});
		
		techScanButton.setOnAction(new EventHandler<>() {
			public void handle(ActionEvent event) {
				System.out.println("Go to tech scan form");
				
				//	Navigate to patient intake form
				SystemControl.screenNav.setScreenTechCTScanWindow();
			}
		});
		
		patientViewButton.setOnAction(new EventHandler<>() {
			public void handle(ActionEvent event) {
				System.out.println("Go to patient log in");
				
				//	Navigate to patient intake form
				SystemControl.screenNav.setScreenPatientLogIn();
			}
		});
	}
}

package hw4;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public final class ScreenNavigation {
	private Stage stage;
	final private int WIDTH = 650;
	final private int HEIGHT = 400;
	private Scene mainView;
	private Scene patientIntakeView;
	private Scene techCTScanView;
	private Scene patientView;
	private Scene patientUserInputView;
	
	
	public ScreenNavigation(Stage stage) {		
		//	Create each window class
		mainView = new Scene(new MainViewWindow().windowRoot, WIDTH, HEIGHT);
		patientIntakeView = new Scene(new PatientIntakeWindow().windowRoot, WIDTH, HEIGHT);
		techCTScanView = new Scene(new TechCTScanWindow().windowRoot, WIDTH, HEIGHT);
		//	patientView = new Scene(new PatientView().windowRoot, WIDTH, HEIGHT);
		patientUserInputView = new Scene(new PatientUserInputWindow().windowRoot, WIDTH, HEIGHT);
		
		//	Testing the stage parameters
		this.stage = stage;
		this.stage.setScene(mainView);
		this.stage.show();
	}
	
	public void setMainView() {
		stage.setScene(mainView);
		stage.show();
	}
	
	public void setScreenPatientIntake() {
		stage.setScene(patientIntakeView);
		stage.show();
	}
	
	public void setScreenTechCTScanWindow() {
		stage.setScene(techCTScanView);
		stage.show();
	}
	
	public void setScreenPatientView(Patient currPatient) {
		patientView = new Scene(new PatientView(currPatient).windowRoot, WIDTH, HEIGHT);
		stage.setScene(patientView);
		stage.show();
	}
	
	public void setScreenPatientLogIn() {
		stage.setScene(patientUserInputView);
		stage.show();
	}
}

package hw4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TechCTScanWindow extends Screen{
	private TextField patientIDTF;
	private TextField totalAgatstonTF;
	private TextField lmTF;
	private TextField ladTF;
	private TextField lcxTF;
	private TextField rcaTF;
	private TextField pdaTF;
	private Label errorLabel;
	
	public TechCTScanWindow() {
		//	Layout Elements
		GridPane vesselScoreGrid = new GridPane();
		vesselScoreGrid.setAlignment(Pos.CENTER_LEFT);
		vesselScoreGrid.setVgap(8.0);
		vesselScoreGrid.setHgap(15.0);
		
		GridPane topGridPane = new GridPane();
		topGridPane.setAlignment(Pos.TOP_LEFT);
		topGridPane.setVgap(8.0);
		topGridPane.setHgap(15.0);
		
		VBox windowVBox = new VBox();
		windowVBox.setAlignment(Pos.TOP_LEFT);
		windowVBox.setPadding(new Insets(25, 25, 25, 25));
		windowVBox.setSpacing(15.0);
		
		//	Necessary Elements
		Label patientIDLabel = new Label("Patient ID:");
		Label totalAgatstonLabel = new Label("The total Agatston CAC score:");
		
		Label vesselLevelLabel = new Label("Vessel level Agatston CAC score");
		
		Label lmLabel = new Label("LM");
		Label ladLabel = new Label("LAD");
		Label lcxLabel = new Label("LCX");
		Label rcaLabel = new Label("RCA");
		Label pdaLabel = new Label("PDA");
		errorLabel = new Label();
		
		patientIDTF = new TextField("");
		patientIDTF.setPrefWidth(350.0);
		
		totalAgatstonTF = new TextField("");
		totalAgatstonTF.setPrefWidth(350.0);
		
		lmTF = new TextField("");
		ladTF = new TextField("");
		lcxTF = new TextField("");
		rcaTF = new TextField("");
		pdaTF = new TextField("");
		
		//	Add elements to the topGridPane
		topGridPane.add(patientIDLabel, 0, 0);
		topGridPane.add(patientIDTF, 1, 0);
		topGridPane.add(totalAgatstonLabel, 0, 1);
		topGridPane.add(totalAgatstonTF, 1, 1);
		
		//	Add elements to the vesselScoreGrid
		vesselScoreGrid.add(lmLabel, 0, 0);
		vesselScoreGrid.add(lmTF, 1, 0);
		vesselScoreGrid.add(ladLabel, 0, 1);
		vesselScoreGrid.add(ladTF, 1, 1);
		vesselScoreGrid.add(lcxLabel, 0, 2);
		vesselScoreGrid.add(lcxTF, 1, 2);
		vesselScoreGrid.add(rcaLabel, 0, 3);
		vesselScoreGrid.add(rcaTF, 1, 3);
		vesselScoreGrid.add(pdaLabel, 0, 4);
		vesselScoreGrid.add(pdaTF, 1, 4);
		
		Button saveButton = new Button("Save");
		saveButton.setPrefSize(75.0, 27.0);
		saveButton.setOnAction(new EventHandler<>() {
			public void handle(ActionEvent event) {
				System.out.println("Create the scan");
				
				//	Referenced Patient 
				Patient targetPatient = null;
				
				//	If the inputfields are all filled
				if(checkAllInputFields()) {
					//	Gather the information from the text fields
					int patientID = Integer.valueOf(patientIDTF.getText());
					int totalAgatston = Integer.valueOf(totalAgatstonTF.getText());
					int lm = Integer.valueOf(lmTF.getText());
					int lad = Integer.valueOf(ladTF.getText());
					int lcx = Integer.valueOf(lcxTF.getText());
					int rca = Integer.valueOf(rcaTF.getText());
					int pda = Integer.valueOf(pdaTF.getText());
					
					//	Create Scan object
					Scan newScan = new Scan(totalAgatston, lm, lad, lcx, rca, pda);
					
					//	Save Scan to patient
					if(SystemControl.database.searchForPatientID(patientID)) {
						targetPatient = SystemControl.database.getPatient(patientID);
						targetPatient.setScan(newScan);
						
						//	Create txt file with all scan information
						try {
							SystemControl.fileManager.createNewPatientScanFile(targetPatient);				
						}catch(Exception e) {
							System.out.println("ERROR: " + e.toString());
						}

						//	Clear the text fields for future use
						patientIDTF.clear();
						totalAgatstonTF.clear();
						lmTF.clear();
						ladTF.clear();
						lcxTF.clear();
						rcaTF.clear();
						pdaTF.clear();
						errorLabel.setText("");
						
						//	Navigate to the main screen
						SystemControl.screenNav.setMainView();
					}else {
						errorLabel.setText("Patient ID does not exist.");
					}
					
				}
			}
		});
		
		//	Add all elements to windowVBox
		windowVBox.getChildren().addAll(topGridPane, vesselLevelLabel, vesselScoreGrid, saveButton, errorLabel);
		
		//	Add windowVBox (which contains all elements) to the windowRoot
		windowRoot.getChildren().add(windowVBox);
	}
	
	private boolean checkAllInputFields() {				
		//	Check all input fields
		if(patientIDTF.getText().compareTo("") == 0 || totalAgatstonTF.getText().compareTo("") == 0 || lmTF.getText().compareTo("") == 0 || ladTF.getText().compareTo("") == 0
				|| lcxTF.getText().compareTo("") == 0 || rcaTF.getText().compareTo("") == 0 || pdaTF.getText().compareTo("") == 0) {
			errorLabel.setText("All input fields must be filled.");
			return false;
		}		
		return true;
	}
}

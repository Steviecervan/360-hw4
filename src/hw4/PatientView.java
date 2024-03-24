package hw4;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PatientView extends Screen{	
	private Label welcomeHeaderLabel;
	private TextField totalAgatstonTF;
	private TextField lmTF;
	private TextField ladTF;
	private TextField lcxTF;
	private TextField rcaTF;
	private TextField pdaTF;
	
	public PatientView(Patient currPatient) {
		System.out.println(currPatient.getPatientForm().getFirstName() + "'s Patient Information");
		
		//	Layout Element
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
		welcomeHeaderLabel = new Label("Hello, " + currPatient.getPatientForm().getFirstName() + " " + currPatient.getPatientForm().getLastName());
		Label totalAgatstonHeaderLabel = new Label("The total Agatston CAC score:");		
		Label lmHeaderLabel = new Label("LM");
		Label ladHeaderLabel = new Label("LAD");
		Label lcxHeaderLabel = new Label("LCX");
		Label rcaHeaderLabel = new Label("RCA");
		Label pdaHeaderLabel = new Label("PDA");
		
		//	Check for scan
		if(currPatient.getPatientScan() != null) {
			Label totalAgatstonLabel = new Label(Integer.toString(currPatient.getPatientScan().getTotalAgatstonScore()));
			Label lmLabel = new Label(Integer.toString(currPatient.getPatientScan().getLMScore()));
			Label ladLabel = new Label(Integer.toString(currPatient.getPatientScan().getLADScore()));
			Label lcxLabel = new Label(Integer.toString(currPatient.getPatientScan().getLCXScore()));
			Label rcaLabel = new Label(Integer.toString(currPatient.getPatientScan().getRCAScore()));
			Label pdaLabel = new Label(Integer.toString(currPatient.getPatientScan().getPDAScore()));
			
			//	Add elements to the vesselScoreGrid
			vesselScoreGrid.add(lmHeaderLabel, 0, 0);
			vesselScoreGrid.add(lmLabel, 1, 0);
			vesselScoreGrid.add(ladHeaderLabel, 0, 1);
			vesselScoreGrid.add(ladLabel, 1, 1);
			vesselScoreGrid.add(lcxHeaderLabel, 0, 2);
			vesselScoreGrid.add(lcxLabel, 1, 2);
			vesselScoreGrid.add(rcaHeaderLabel, 0, 3);
			vesselScoreGrid.add(rcaLabel, 1, 3);
			vesselScoreGrid.add(pdaHeaderLabel, 0, 4);
			vesselScoreGrid.add(pdaLabel, 1, 4);
			
			//	Add elements to the topGridPane
			topGridPane.add(totalAgatstonHeaderLabel, 0, 0);
			topGridPane.add(totalAgatstonLabel, 1, 0);
			
			//	Add all elements to windowVBox
			windowVBox.getChildren().addAll(welcomeHeaderLabel, topGridPane, vesselScoreGrid);		
			
		}else {
			Label errorLabel = new Label("Scan does not exist or is being processed. Try again later!");
			windowVBox.getChildren().addAll(welcomeHeaderLabel, topGridPane, errorLabel);
		}
		
		//	Add windowVBox (which contains all elements) to the windowRoot
		windowRoot.getChildren().add(windowVBox);			
	}
}

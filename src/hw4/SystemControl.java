package hw4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SystemControl extends Application{
	private static StackPane root;
	public static ScreenNavigation screenNav;
	public static FileManager fileManager;
	public static Database database;
	
	
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage stage) {		
		//	Create the Screen Navigation Class
		//	This class will manage all the screens
		screenNav = new ScreenNavigation(stage);
		
		//	Create the File Manager Class
		//	This create the patient files
		fileManager = new FileManager();
		
		//	Create the Database class
		//	This class will keep track of the patients
		database = new Database();
	}
	
	
}

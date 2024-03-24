package hw4;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Screen extends Pane{
	public StackPane windowRoot;
	
	public Screen() {
		windowRoot = new StackPane();
		windowRoot.setAlignment(Pos.CENTER);
	}
}

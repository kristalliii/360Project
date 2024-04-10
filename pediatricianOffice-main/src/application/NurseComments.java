package application;



import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NurseComments {
	
	public Scene NurseCommentScene(Stage primaryStage) {
		
		Group rootNode = new Group();
		
		Label Patientcom = new Label("Patient Comments");
		Patientcom.setLayoutX(240);
		Patientcom.setLayoutY(0);
		Patientcom.setFont(new Font(22));
		
		TextArea patientcom = new TextArea();
		patientcom.setLayoutX(50);
		patientcom.setLayoutY(60);
		patientcom.setMinSize(300,300);
		patientcom.setPrefHeight(450);
		patientcom.setPrefWidth(550);
		
		Button submit = new Button("Submit");
		submit.setPrefWidth(60);
		submit.setPrefHeight(30);
		submit.setLayoutX(500);
		submit.setLayoutY(530);
		
		
		rootNode.getChildren().addAll(Patientcom, patientcom, submit);
		
		VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(rootNode);
        
        Scene scene2 = new Scene(layout, 600, 600);
        return scene2;
	}

}

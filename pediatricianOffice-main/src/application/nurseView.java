package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class nurseView extends PediatricianOffice {
	TextField patientName = new TextField();
	Label vitalsLabel = createLabel("VITALS: ", 20);
	
	Label ageLabel = createLabel("AGE: ", 15);
	TextField age = new TextField();
	
	Label heightLabel = createLabel("HEIGHT: ", 15);
	TextField height = new TextField();
	
	Label weightLabel = createLabel("WEIGHT: ", 15);
	TextField weight = new TextField();
	
	Label bpLabel = createLabel("BLOOD PRESSURE: ", 15);
	TextField bp = new TextField();
	
	Label tempLabel = createLabel("TEMPERATURE: ", 15);
	TextField temp = new TextField();
	
	DatePicker today = new DatePicker();
	CheckBox aboveTwelve = new CheckBox("ABOVE AGE 12");
	
	Label allergiesLabel = createLabel("ALLERGIES: ", 15);
	TextArea allergies = new TextArea();
	
	Label medsLabel = createLabel("MEDICATIONS: ", 15);
	TextArea meds = new TextArea();

	GridPane g = new GridPane();
	VBox v1 = new VBox();
	VBox v2 = new VBox();
	Scene createNurseView() {
		v1.getChildren().addAll(ageLabel, heightLabel, weightLabel, bpLabel, tempLabel);
		v2.getChildren().addAll(age, height, weight, bp, temp);
		g.add(patientName, 0, 0); //insert patient name at (0,0)
		g.add(aboveTwelve, 1, 0);
		g.add(vitalsLabel, 0, 1);
		g.add(v1, 0, 2);
		g.add(v2, 1, 2);
		VBox a = new VBox();
		a.getChildren().addAll(allergiesLabel, allergies);
		g.add(a, 2, 1);
		VBox m = new VBox();
		m.getChildren().addAll(medsLabel, meds);
		g.add(m, 2, 2);
		g.setAlignment(Pos.CENTER);
		
		g.getColumnConstraints().add(new ColumnConstraints(180));
		g.getColumnConstraints().add(new ColumnConstraints(200));
		g.getColumnConstraints().add(new ColumnConstraints(200));
		
		g.setHgap(25);
		g.setVgap(20);
		//g.setGridLinesVisible(true);
		return new Scene(g, 700,400);
	}
}

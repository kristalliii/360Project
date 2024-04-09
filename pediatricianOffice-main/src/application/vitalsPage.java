package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

class nurseView extends PediatricianOffice {
	TextField patientName = new TextField();
	Label vitalsLabel = createLabel("VITALS: ", 20);
	Label ageLabel = createLabel("AGE: ", 20);
	Label heightLabel = createLabel("HEIGHT: ", 20);
	Label weightLabel = createLabel("WEIGHT: ", 20);
	Label bpLabel = createLabel("BLOOD PRESSURE: ", 20);
	Label tempLabel = createLabel("TEMPERATURE: ", 20);
	DatePicker today = new DatePicker();
	CheckBox aboveTwelve = new CheckBox("ABOVE AGE 12");
	Label allergiesLabel = createLabel("ALLERGIES: ", 20);
	Label medsLabel = createLabel("MEDICATIONS: ", 20);
	TextField age = new TextField();
	TextField height = new TextField();
	TextField weight = new TextField();
	TextField bp = new TextField();
	TextField temp = new TextField();
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
		g.setAlignment(Pos.CENTER);
		g.getColumnConstraints().add(new ColumnConstraints(180));
		g.getColumnConstraints().add(new ColumnConstraints(400));
		g.setHgap(25);
		g.setVgap(20);
		return new Scene(g, 700,400);
	}
}

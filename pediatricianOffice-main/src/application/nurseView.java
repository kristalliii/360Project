package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class nurseView extends PediatricianOffice {
	Label patient = createLabel("Patient Name: ", 20);
	TextField patientName = new TextField();
	Label vitalsLabel = createLabel("VITALS: ", 15);
	
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
	
	Label patientIn = createLabel("Nurse", 30);
	
	BorderPane b = new BorderPane();
	GridPane g = new GridPane();
	HBox buttons = new HBox(20);
	HBox name = new HBox(20);
	
	Button inbox = createButton("Inbox", 100, 40);
	Button next = createButton("Next", 80, 40);
	
	Scene createNurseView(Stage s, String fn, String ln, doctorMessagingSystem d) {
		g.add(vitalsLabel, 0, 0);
		g.add(aboveTwelve, 1, 0);
		g.add(ageLabel, 0, 1);
		g.add(age, 1, 1);
		g.add(heightLabel, 0, 2);
		g.add(height, 1, 2);
		g.add(weightLabel, 0, 3);
		g.add(weight, 1, 3);
		g.add(bpLabel, 0, 4);
		g.add(bp, 1, 4);
		g.add(tempLabel, 0, 5);
		g.add(temp, 1, 5);
		VBox v = new VBox();
		VBox v2 = new VBox();
		allergies.setPrefSize(200, 150);
		allergies.setWrapText(true);
		meds.setPrefSize(200, 150);
		meds.setWrapText(true);
		name.getChildren().addAll(patient, patientName);
		v.getChildren().addAll(allergiesLabel, allergies, medsLabel, meds);
		v2.getChildren().addAll(name, g);
		
		g.setHgap(10);
		g.setVgap(5);
		
		buttons.getChildren().addAll(inbox, next);
		
		b.setTop(patientIn);
		b.setCenter(v2);
		b.setRight(v);
		b.setBottom(buttons);
		b.setPadding(new Insets(15, 15, 15, 15));
		b.setMargin(v2, new Insets(15, 15, 15, 15));
		b.setMargin(buttons, new Insets(15, 15, 15, 15));
		b.setAlignment(patientIn, Pos.TOP_CENTER);
		buttons.setAlignment(Pos.CENTER);
		
		inbox.setOnAction(new EventHandler<>() {
			@Override
			public void handle(ActionEvent e) {
				s.setScene(d.createInboxView(s, fn + ln));
				s.show();
			}
		});
		
		return new Scene(b, 600,400);
	}
}

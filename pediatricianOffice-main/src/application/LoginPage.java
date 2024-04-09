package application;

import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LoginPage extends PediatricianOffice{
	Label medBridge = createLabel("MedBridge", 50);
	Label subTitle = createLabel("PEDIATRICS HEALTH SERVICE", 20);
	Button doctor = createButton("Doctor Login", 300, 70);
	Button nurse = createButton("Nurse Login", 300, 70);
	Button patient = createButton("Patient Login", 300, 70);
	
	Label fnLabel = createLabel("First Name: ", 20);
	TextField fName = new TextField();
	Label lnLabel = createLabel("Last Name: ", 20);
	TextField lName = new TextField();
	Label DOBLabel = createLabel("Date of Birth (MM/DD/YYYY)", 20);
	final DatePicker DOB = new DatePicker();
	LocalDate date = DOB.getValue();
	VBox loginPage = new VBox(20);
	Button loginBtn = new Button("Login");
	
	Scene createLogin() {
		VBox buttons = new VBox(20);
		buttons.getChildren().addAll(medBridge, subTitle, doctor, nurse, patient);
		buttons.setAlignment(Pos.CENTER);
		return new Scene(buttons, 700, 400);
	}
	Scene doctorLogin() {
		GridPane labels = new GridPane();
		labels.add(fnLabel, 0, 0);
		labels.add(fName, 1, 0);
		labels.add(lnLabel, 0, 1);
		labels.add(lName, 1, 1);
		labels.add(DOBLabel, 0, 2);
		labels.add(DOB, 1, 2);
		labels.setAlignment(Pos.TOP_CENTER);
		loginPage.getChildren().addAll(medBridge, subTitle, labels, loginBtn);
		loginPage.setAlignment(Pos.TOP_CENTER);
		return new Scene(loginPage, 700, 400);
	}
	Scene patientLogin() {
		GridPane labels = new GridPane();
		labels.add(fnLabel, 0, 0);
		labels.add(fName, 1, 0);
		labels.add(lnLabel, 0, 1);
		labels.add(lName, 1, 1);
		labels.add(DOBLabel, 0, 2);
		labels.add(DOB, 1, 2);
		labels.setAlignment(Pos.TOP_CENTER);
		loginPage.getChildren().addAll(medBridge, subTitle, labels, loginBtn);
		loginPage.setAlignment(Pos.TOP_CENTER);
		return new Scene(loginPage, 700, 400);
	}
	Scene nurseLogin() {
		GridPane labels = new GridPane();
		labels.add(fnLabel, 0, 0);
		labels.add(fName, 1, 0);
		labels.add(lnLabel, 0, 1);
		labels.add(lName, 1, 1);
		labels.add(DOBLabel, 0, 2);
		labels.add(DOB, 1, 2);
		labels.setAlignment(Pos.TOP_CENTER);
		loginPage.getChildren().addAll(medBridge, subTitle, labels, loginBtn);
		loginPage.setAlignment(Pos.TOP_CENTER);
		return new Scene(loginPage, 700, 400);
	}
}
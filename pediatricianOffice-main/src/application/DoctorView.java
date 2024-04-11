package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;

public class DoctorView extends PediatricianOffice{
	String fn, ln;
	LocalDate dateOfBirth;
	Group rootNode = new Group();
    TextField weighttf = new TextField();
    TextField heighttf = new TextField();
    TextField bptf = new TextField();
    TextField bttf = new TextField();
	TextField historytf = new TextField();
	Button submit = new Button("Submit");
	TextArea TResult = new TextArea();
	TextArea pta = new TextArea();
	public Scene DoctorViewScene(Stage primaryStage, String fName, String lName, LocalDate dOB) {
		try {
			Scanner read = new Scanner(new File("Patient" + fName + lName + dOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "Intake.txt"));
			fName = read.nextLine();
			lName = read.nextLine();
			String dob = read.nextLine();
			String age = read.nextLine();
			heighttf.setText(read.nextLine());
			weighttf.setText(read.nextLine());
			bptf.setText(read.nextLine());
			bttf.setText(read.nextLine());
			historytf.setText(read.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Label Patientinfo = new Label("Patient Information");
		Patientinfo.setLayoutX(220);
		Patientinfo.setLayoutY(0);
		Patientinfo.setFont(new Font(22));
		
		//patient name
		Label name = new Label("Name: ");
		name.setLayoutX(30);
		name.setLayoutY(50);
		
		fn = fName;
		ln = lName;
		TextField nametf = new TextField(fn + " " + ln);
        nametf.setEditable(false);
        nametf.setLayoutX(80);
        nametf.setLayoutY(48);
		
		//patient dob
        Label dob = new Label("Date of Birth: ");
        dob.setLayoutX(280);
        dob.setLayoutY(130);
        
        dateOfBirth = dOB;
        TextField dobtf = new TextField(dateOfBirth.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        dobtf.setLayoutX(380);
        dobtf.setLayoutY(128);
        dobtf.setEditable(false);
		
		//patient weight
        Label weight = new Label("Weight: ");
        weight.setLayoutX(30);
        weight.setLayoutY(90);
        
        weighttf.setLayoutX(80);
        weighttf.setLayoutY(88);
		
		//patient height
        Label height = new Label("Height: ");
        height.setLayoutX(30);
        height.setLayoutY(130);
        
        heighttf.setLayoutX(80);
        heighttf.setLayoutY(128);
		
		//patient bp
        Label bp = new Label("Blood Pressure: ");
        bp.setLayoutX(290);
        bp.setLayoutY(50);
        
        bptf.setLayoutX(380);
        bptf.setLayoutY(48);
		
		//patient bt
        Label bt = new Label("Blood Temperature: ");
        bt.setLayoutX(270);
        bt.setLayoutY(90);
        
        bttf.setLayoutX(380);
        bttf.setLayoutY(88);
		
        //Test Result / Comments
		Label TResults = new Label("Physical Test Results / Comments");
		TResults.setLayoutX(135);
		TResults.setLayoutY(180);
		TResults.setFont(new Font(22));
		
		TResult.setLayoutX(20);
		TResult.setLayoutY(210);
		TResult.setMinSize(560, 50);
		TResult.setPrefHeight(120);
		
		//Prescription
		Label prescription = new Label("Prescriptions");
		prescription.setLayoutX(370);
		prescription.setLayoutY(350);
		prescription.setFont(new Font(22));
		
		pta.setLayoutX(300);
		pta.setLayoutY(390);
		pta.setMinSize(280, 50);
		pta.setPrefHeight(130);
		pta.setPrefWidth(50);
		
		//History
		Label history = new Label("Previous History");
		history.setLayoutX(70);
		history.setLayoutY(350);
		history.setFont(new Font(22));
		
		historytf.setLayoutX(20);
		historytf.setLayoutY(390);
		historytf.setEditable(false);
		historytf.setMinHeight(130);
		historytf.setMinWidth(250);
		
		//submit button
		submit.setPrefWidth(60);
		submit.setPrefHeight(30);
		submit.setLayoutX(500);
		submit.setLayoutY(530);
		
		rootNode.getChildren().addAll( Patientinfo, name, nametf,  weight, weighttf, height, heighttf, bp, bptf, bt, bttf, TResults, TResult, prescription, pta, history, historytf, submit, dob, dobtf);
		
		VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(rootNode);	

        Scene scene2 = new Scene(layout, 600, 600);
        return scene2;
	}
}

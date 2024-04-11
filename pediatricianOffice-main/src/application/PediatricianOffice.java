package application;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class PediatricianOffice extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {		
		LoginPage loginPage = new LoginPage(); //login page
		VBox signupPage = new VBox(20); //signup page
		nurseView nurseView = new nurseView(); //nurse vitals view
		PatientView patientView = new PatientView(); //patient's view
		DoctorView docView = new DoctorView();
		
		User u = new User();
		CreateAccount signUp = new CreateAccount();
		patientMessagingSystem patientMsgs = new patientMessagingSystem();
		doctorMessagingSystem docMsgs = new doctorMessagingSystem();
		

		//login page button functionality
		 loginPage.doctor.setOnAction(e -> {
		        primaryStage.setScene(loginPage.doctorLogin());
		        primaryStage.show();
		    });
		
	
		 loginPage.patient.setOnAction(e -> {
		        primaryStage.setScene(loginPage.patientLogin());
		        primaryStage.show();
		    });
		 
	
		 loginPage.nurse.setOnAction(e -> {
		        primaryStage.setScene(loginPage.nurseLogin());
		        primaryStage.show();
		    });
		//diff users login
			loginPage.docLogin.setOnAction(new EventHandler<>() { //doc login, create doc view
				@Override
				public void handle(ActionEvent e) {
					loginPage.date = loginPage.DOB.getValue();
					if(u.docExists(loginPage.fName.getText(), loginPage.lName.getText(), loginPage.date)) {
						primaryStage.setScene(docView.DoctorViewScene(primaryStage, loginPage.fName.getText(), loginPage.lName.getText(), loginPage.date));
					} else {
						primaryStage.setScene(signUp.createDocAccountScene(u));
						primaryStage.show();
					}
				}
			});
			loginPage.nursLogin.setOnAction(new EventHandler<>() { //nurse login, create nurse view
				@Override
				public void handle(ActionEvent e) {
					loginPage.date = loginPage.DOB.getValue();
					if(u.nurseExists(loginPage.fName.getText(), loginPage.lName.getText(), loginPage.date)) {
						primaryStage.setScene(nurseView.createNurseView(primaryStage, loginPage.fName.getText(), loginPage.lName.getText()));
					} else {
						primaryStage.setScene(signUp.createNursAccountScene(u));
						primaryStage.show();
					}
				}
			});
			loginPage.patLogin.setOnAction(new EventHandler<>() { //patient login, create patient view
				@Override
				public void handle(ActionEvent e) {
					loginPage.date = loginPage.DOB.getValue();
					if(u.patientExists(loginPage.fName.getText(), loginPage.lName.getText(), loginPage.date)) {
						primaryStage.setScene(patientView.createPatientViewScene(primaryStage, loginPage.fName.getText(), loginPage.lName.getText(), loginPage.date));
					} else {
						primaryStage.setScene(signUp.createPatAccountScene(u));						
						primaryStage.show();
					}
				}
			});
			
			//create acc buttons
			signUp.submitDoc.setOnAction(e -> { //create doc acc
				signUp.date = loginPage.DOB.getValue();
	            if(signUp.createAccount(signUp.fNameField.getText(), signUp.lNameField.getText(), signUp.date)) {
	            	u.writeDocFile(signUp.fNameField.getText(), signUp.lNameField.getText(), signUp.date);
	            } else {
	                System.out.print("EMPTY INPUT");
	            }
	        });
			signUp.submitNurs.setOnAction(e -> { //create nurse acc
				signUp.date = loginPage.DOB.getValue();
	            if(signUp.createAccount(signUp.fNameField.getText(), signUp.lNameField.getText(), signUp.date)) {
	            	u.writeNurseFile(signUp.fNameField.getText(), signUp.lNameField.getText(), signUp.date);
	            } else {
	                System.out.print("EMPTY INPUT");
	            }
	        });
			signUp.submitPat.setOnAction(e -> { //create patient acc
				signUp.date = loginPage.DOB.getValue();
	            if(signUp.createAccount(signUp.fNameField.getText(), signUp.lNameField.getText(), signUp.date)) {
	            	u.writePatientFile(signUp.fNameField.getText(), signUp.lNameField.getText(), signUp.date);
	            } else {
	                System.out.print("EMPTY INPUT");
	            }
	        });
			
			//button functionality for nurse view
			nurseView.inbox.setOnAction(new EventHandler<>() { //change to nurse inbox
				@Override
				public void handle(ActionEvent e) {
					primaryStage.setScene(docMsgs.createInboxView(primaryStage, loginPage.fName.toString() + " " + loginPage.lName.toString()));			
				}
			});
			nurseView.next.setOnAction(new EventHandler<>() { //write patient intake file
				@Override
				public void handle(ActionEvent e) {
					String[] pName = nurseView.patientName.getText().split(" ");
					//u.writePatientIntake(pName[0], pName[1], null);	
				}
			});
			
			//button functionality for doctor view
		
		primaryStage.setTitle("MedBridge Pediatrician Office");
		primaryStage.setScene(loginPage.createLogin());
		primaryStage.show();
	}
	public Button createButton(String s, double w, double h) {
		Button button = new Button(s);
		button.setPrefSize(w, h);
		button.setFont(new Font(20));
		button.setStyle("-fx-background-color: #4874c4");
		return button;
	}
	
	public Label createLabel(String s, int f) {
		Label label = new Label(s);
		label.setFont(new Font(f));
		return label;
	}
}
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
		
		ArrayList<Doctor> docs = new ArrayList<Doctor>();
		ArrayList<Nurse> nurses = new ArrayList<Nurse>();
		
		loginPage.loginBtn.setOnAction(new EventHandler<>(){
			@Override
			public void handle(ActionEvent event) {	
				for(Doctor d: docs) {
					//if name is in doc list, sign in to doc
				}
				for(Nurse n: nurses) {
				//if name is in nurse list, sign in to nurse
				}
				
				//if name is in patient file, sign in + load patient info
				primaryStage.setScene(new Scene(signupPage));
				primaryStage.show();
			}
		});
		loginPage.doctor.setOnAction(new EventHandler<>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(docView.DoctorViewScene(primaryStage, loginPage.fName.getText(), loginPage.fName.getText(), loginPage.date));
				primaryStage.show();
			}
		});
		loginPage.patient.setOnAction(new EventHandler<>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(patientView.createPatientViewScene(primaryStage, loginPage.fName.getText(), loginPage.fName.getText(), loginPage.date));
				primaryStage.show();
			}
		});
		loginPage.nurse.setOnAction(new EventHandler<>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(nurseView.createNurseView());
				primaryStage.show();
			}
		});
		
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
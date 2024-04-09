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
		primaryStage.setTitle("MedBridge Pediatrician Office");
		
		LoginPage login = new LoginPage(); //login page
		VBox signupPage = new VBox(20); //signup page
		nurseView nurse = new nurseView(); //nurse vitals view
		
		login.loginBtn.setOnAction(new EventHandler<>(){
		@Override
			public void handle(ActionEvent event) {	
				primaryStage.setScene(new Scene(signupPage));
				primaryStage.show();
			}
		});

		primaryStage.setScene(nurse.createNurseView());
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
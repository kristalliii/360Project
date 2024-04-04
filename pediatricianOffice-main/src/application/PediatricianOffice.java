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
		//login page
		Label medBridge = new Label("MedBridge");
		medBridge.setFont(new Font(50));
		
		Label subTitle = new Label("PEDIATRICS HEALTH SERVICE");
		subTitle.setFont(new Font(20));
		Label fnLabel = new Label("First Name: ");
		TextField fName = new TextField();
		Label lnLabel = new Label("Last Name: ");
		TextField lName = new TextField();
		Label DOBLabel = new Label("Date of Birth (MM/DD/YYYY)");
		final DatePicker DOB = new DatePicker();
		LocalDate date = DOB.getValue();
		GridPane labels = new GridPane();
		labels.add(fnLabel, 0, 0);
		labels.add(fName, 1, 0);
		labels.add(lnLabel, 0, 1);
		labels.add(lName, 1, 1);
		labels.add(DOBLabel, 0, 2);
		labels.add(DOB, 1, 2);
		labels.setAlignment(Pos.TOP_CENTER);
		
		//signup page
		VBox signupPage = new VBox(20);
		
		
		
		
		Button loginBtn = new Button("Login");
		LoginPage l = new LoginPage();
		loginBtn.setOnAction(new EventHandler<>(){
		@Override
			public void handle(ActionEvent event) {
				if(l.loggedIn(fName.getText(), lName.getText(), date)){
					primaryStage.setScene(new Scene(signupPage));
					primaryStage.show();
				} //else {}  create acc button show up + create acc page
			}
		});
		
		VBox loginPage = new VBox(20);
		loginPage.getChildren().addAll(medBridge, subTitle, labels, loginBtn);
		loginPage.setAlignment(Pos.TOP_CENTER);
		
		primaryStage.setTitle("MedBridge Pediatrician Office");
		primaryStage.setScene(new Scene(loginPage, 600, 600));
		primaryStage.show();
	}
}
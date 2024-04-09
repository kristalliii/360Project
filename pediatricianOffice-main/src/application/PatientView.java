package application;

import java.time.LocalDate;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PatientView extends PediatricianOffice{
	 public Scene createPatientViewScene(Stage primaryStage, String firstName, String lastName, LocalDate dateOfBirth) {
	        // Labels for patient information
	        Label patientInfoLabel = new Label("Patient Information");
	        patientInfoLabel.setFont(new Font(20));

	        Label nameLabel = new Label("Name:");
	        TextField nameTextField = new TextField(firstName + " " + lastName);
	        nameTextField.setEditable(false);

	        Label dobLabel = new Label("Date of Birth:");
	        TextField dobTextField = new TextField(dateOfBirth.toString());
	        dobTextField.setEditable(false);

	        // Labels for vitals
	        Label vitalsLabel = new Label("Vitals");
	        vitalsLabel.setFont(new Font(20));

	        Label weightLabel = new Label("Weight:");
	        TextField weightTextField = new TextField();

	        Label heightLabel = new Label("Height:");
	        TextField heightTextField = new TextField();

	        Label temperatureLabel = new Label("Body Temperature:");
	        TextField temperatureTextField = new TextField();

	        Label bloodPressureLabel = new Label("Blood Pressure:");
	        TextField bloodPressureTextField = new TextField();

	        // Allergies/concerns
	        Label allergiesLabel = new Label("Allergies/Concerns");
	        allergiesLabel.setFont(new Font(20));

	        TextArea allergiesTextArea = new TextArea();
	        allergiesTextArea.setPrefHeight(100);
	        allergiesTextArea.setWrapText(true);

	        // Previous history
	        Label historyLabel = new Label("Previous History");
	        historyLabel.setFont(new Font(20));

	        TextArea historyTextArea = new TextArea();
	        historyTextArea.setPrefHeight(150);
	        historyTextArea.setWrapText(true);

	        // Grid for layout
	        GridPane gridPane = new GridPane();
	        gridPane.setAlignment(Pos.TOP_CENTER);
	        gridPane.setHgap(10);
	        gridPane.setVgap(10);

	        // Add patient information components to the grid
	        gridPane.add(patientInfoLabel, 0, 0, 2, 1);
	        gridPane.add(nameLabel, 0, 1);
	        gridPane.add(nameTextField, 1, 1);
	        gridPane.add(dobLabel, 0, 2);
	        gridPane.add(dobTextField, 1, 2);

	        // Add vitals components to the grid
	        gridPane.add(vitalsLabel, 0, 3, 2, 1);
	        gridPane.add(weightLabel, 0, 4);
	        gridPane.add(weightTextField, 1, 4);
	        gridPane.add(heightLabel, 0, 5);
	        gridPane.add(heightTextField, 1, 5);
	        gridPane.add(temperatureLabel, 0, 6);
	        gridPane.add(temperatureTextField, 1, 6);
	        gridPane.add(bloodPressureLabel, 0, 7);
	        gridPane.add(bloodPressureTextField, 1, 7);

	        // Add allergies/concerns components to the grid
	        gridPane.add(allergiesLabel, 0, 8, 2, 1);
	        gridPane.add(allergiesTextArea, 0, 9, 2, 1);

	        // Add previous history components to the grid
	        gridPane.add(historyLabel, 0, 10, 2, 1);
	        gridPane.add(historyTextArea, 0, 11, 2, 1);

	        // Buttons
	        HBox buttons = new HBox(10);
	        buttons.setAlignment(Pos.CENTER);
	        Button saveButton = new Button("Save");
	        Button cancelButton = new Button("Cancel");
	        buttons.getChildren().addAll(saveButton, cancelButton);

	        // Layout
	        VBox layout = new VBox(20);
	        layout.setAlignment(Pos.TOP_CENTER);
	        layout.setPadding(new Insets(20));
	        layout.getChildren().addAll(gridPane, buttons);

	        // Scene
	        Scene scene = new Scene(layout, 600, 600);
	        return scene;
	    }
}

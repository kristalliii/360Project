package application;

import java.time.LocalDate;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class CreateAccount extends PediatricianOffice {
	Label medBridge = createLabel("MedBridge", 50);
    Label subTitle = createLabel("NO ACCOUNT FOUND, CREATE ACCOUNT", 20);
    Label fnLabel = new Label("First Name: ");
    TextField fNameField = new TextField();
    Label lnLabel = new Label("Last Name: ");
    TextField lNameField = new TextField();
    Label dobLabel = new Label("Date of Birth (MM/DD/YYYY): ");
    DatePicker dobPicker = new DatePicker();
    LocalDate date = dobPicker.getValue();
    GridPane gridPane = new GridPane();
    Button submitDoc = new Button("Submit");
    Button submitNurs = new Button("Submit");
    Button submitPat = new Button("Submit");
   
    public Scene createDocAccountScene(User u) {
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(fnLabel, 1, 1);
        gridPane.add(fNameField, 2, 1);
        gridPane.add(lnLabel, 1, 2);
        gridPane.add(lNameField, 2, 2);
        gridPane.add(dobLabel, 1, 3);
        gridPane.add(dobPicker, 2, 3);

        VBox vBox = new VBox(20, medBridge, subTitle, gridPane, submitDoc);
        vBox.setAlignment(Pos.TOP_CENTER);

        return new Scene(vBox, 700, 400);
    }
    public Scene createNursAccountScene(User u) {
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(fnLabel, 1, 1);
        gridPane.add(fNameField, 2, 1);
        gridPane.add(lnLabel, 1, 2);
        gridPane.add(lNameField, 2, 2);
        gridPane.add(dobLabel, 1, 3);
        gridPane.add(dobPicker, 2, 3);
        
        VBox vBox = new VBox(20, medBridge, subTitle, gridPane, submitNurs);
        vBox.setAlignment(Pos.TOP_CENTER);

        return new Scene(vBox, 700, 400);
    }
    public Scene createPatAccountScene(User u) {
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(fnLabel, 1, 1);
        gridPane.add(fNameField, 2, 1);
        gridPane.add(lnLabel, 1, 2);
        gridPane.add(lNameField, 2, 2);
        gridPane.add(dobLabel, 1, 3);
        gridPane.add(dobPicker, 2, 3);

        VBox vBox = new VBox(20, medBridge, subTitle, gridPane, submitPat);
        vBox.setAlignment(Pos.TOP_CENTER);

        return new Scene(vBox, 700, 400);
    }
    
   
    public boolean createAccount(String fn, String ln, LocalDate doB) {
        return !fn.isEmpty() && !ln.isEmpty() && doB != null;
    }
}
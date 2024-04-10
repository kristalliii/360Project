package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDate;

public class doctorMessagingSystem{

    public Scene createInboxView(Stage primaryStage, String doctorName) {
        // Labels for doctor information
        Label doctorInfoLabel = new Label("Doctor Information");
        doctorInfoLabel.setFont(new Font(20));

        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField(doctorName);
        nameTextField.setEditable(false);

        // Message inbox
        Label inboxLabel = new Label("Inbox");
        inboxLabel.setFont(new Font(20));

        ListView<String> messageListView = new ListView<>();
        messageListView.getItems().addAll("Message 1", "Message 2", "Message 3");
        messageListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Text area for reply
        Label replyLabel = new Label("Reply:");
        TextArea replyTextArea = new TextArea();
        replyTextArea.setWrapText(true);

        // Buttons
        Button sendMessageButton = new Button("Send Message");
        sendMessageButton.setOnAction(e -> {
            String message = replyTextArea.getText();
            if (!message.isEmpty()) {
                // Logic to send message
                replyTextArea.clear();
                // Update inbox view
                messageListView.getItems().add("You: " + message);
                // Simulate receiving a message from patient portal
                String patientMessage = "Patient: " + message;
                // Assuming there's a method to receive messages from patient portal
                receiveMessageFromPatientPortal(patientMessage);
            }
        });

        Button deleteMessageButton = new Button("Delete Message");
        deleteMessageButton.setOnAction(e -> {
            String selectedMessage = messageListView.getSelectionModel().getSelectedItem();
            if (selectedMessage != null) {
                // Logic to delete message
                messageListView.getItems().remove(selectedMessage);
            }
        });

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(doctorInfoLabel, 0, 0, 2, 1);
        gridPane.add(nameLabel, 0, 1);
        gridPane.add(nameTextField, 1, 1);
        gridPane.add(inboxLabel, 0, 2, 2, 1);
        gridPane.add(messageListView, 0, 3, 2, 1);
        gridPane.add(replyLabel, 0, 4);
        gridPane.add(replyTextArea, 0, 5, 2, 1);

        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(sendMessageButton, deleteMessageButton);

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(gridPane, buttons);

        // Scene
        Scene scene = new Scene(layout, 600, 600);
        return scene;
    }

    // Method to simulate receiving messages from patient portal
    private void receiveMessageFromPatientPortal(String message) {
        // Logic to receive message from patient portal
        // For simulation, let's just print the received message
        System.out.println("Received message from patient portal: " + message);
    }
}

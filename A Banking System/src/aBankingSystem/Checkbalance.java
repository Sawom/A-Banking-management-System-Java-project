package aBankingSystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;

public class Checkbalance implements Serializable {
    public Checkbalance() {
        Stage primaryStage = new Stage();
        TextField tfaccNum = new TextField();
        Button Add = new Button("Click Here");
        Label label1 = new Label("Enter Account Number:");

        Label lblResult = new Label("");

        Add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblResult.setText("");
                String accountNumber = tfaccNum.getText().trim();

                if (accountNumber.isEmpty()) {
                    lblResult.setText("Please enter an Account Number!");
                    return;
                }

                try {
                    Main.bc.getBalance(accountNumber);

                    File file = new File(accountNumber + ".txt");
                    if (file.exists()) {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line = reader.readLine();
                        reader.close();

                        if (line != null) {
                            String[] parts = line.split(":");
                            if (parts.length >= 3) {
                                String balance = parts[2];
                                String name = parts[1];

                                lblResult.setText("Account Holder: " + name + " | Current Balance: " + balance);
                            } else {
                                lblResult.setText("File format error!");
                            }
                        }
                    } else {
                        lblResult.setText("Account not found! File does not exist.");
                    }

                } catch (Exception e) {
                    lblResult.setText("Error retrieving balance!");
                    e.printStackTrace();
                }
            }
        });

        VBox vbox = new VBox(10);
        tfaccNum.setMaxWidth(180);

        vbox.getChildren().addAll(label1, tfaccNum, Add, lblResult);

        Scene SecondScene = new Scene(vbox, 500, 250);
        Stage newWindow = new Stage();
        newWindow.setTitle("Check Balance");
        newWindow.setScene(SecondScene);
        newWindow.setX(primaryStage.getX() + 350);
        newWindow.setY(primaryStage.getY() + 0);

        newWindow.show();
    }
}

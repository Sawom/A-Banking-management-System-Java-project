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

public class Deposit implements Serializable {
    public Deposit() {
        Stage primaryStage = new Stage();
        TextField tfaccNum = new TextField();
        TextField tfdepAmount = new TextField();

        Button Add = new Button("Click Here");
        Label label1 = new Label("Enter Account Number");
        Label label2 = new Label("Enter Deposit Amount:");

        Label lblResult = new Label("");

        Add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    String accNum = tfaccNum.getText().trim();
                    String amountStr = tfdepAmount.getText().trim();

                    if (accNum.isEmpty() || amountStr.isEmpty()) {
                        lblResult.setText("Please fill in all fields!");
                        return;
                    }

                    int depositAmount = Integer.parseInt(amountStr);

                    Main.bc.deposit(accNum, depositAmount);

                    File file = new File(accNum + ".txt");
                    if (file.exists()) {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line = reader.readLine();
                        reader.close();

                        if (line != null) {
                            String[] parts = line.split(":");
                            if (parts.length >= 3) {
                                String currentBalance = parts[2];

                                lblResult.setText("Success! Deposited " + depositAmount + ". Total Balance: " + currentBalance);
                            } else {
                                lblResult.setText("Deposit successful, but file format error!");
                            }
                        }
                    } else {
                        lblResult.setText("Account file not found!");
                    }

                } catch (NumberFormatException e) {
                    lblResult.setText("Error: Please enter a valid number!");
                } catch (IOException e) {
                    lblResult.setText("Error reading account file!");
                    e.printStackTrace();
                } catch (Exception e) {
                    lblResult.setText("An error occurred!");
                    e.printStackTrace();
                }
            }
        });

        VBox vbox = new VBox(10);
        tfaccNum.setMaxWidth(180);
        tfdepAmount.setMaxWidth(180);

        vbox.getChildren().addAll(label1, tfaccNum, label2, tfdepAmount, Add, lblResult);

        Scene SecondScene = new Scene(vbox, 500, 300);
        Stage newWindow = new Stage();
        newWindow.setTitle("Deposit Money");
        newWindow.setScene(SecondScene);
        newWindow.setX(primaryStage.getX() + 350);
        newWindow.setY(primaryStage.getY() + 0);
        newWindow.show();
    }
}

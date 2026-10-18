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
import java.util.Random;

public class CurrentAccounts implements Serializable {
    public CurrentAccounts() {
        Stage primaryStage = new Stage();
        TextField tfmemberName = new TextField();
        TextField tfaccountBalance = new TextField();
        TextField tflicense = new TextField();

        Button Add = new Button("Click Here");
        Label label1 = new Label("Enter Member Name");
        Label label2 = new Label("Enter Account Balance:");
        Label label3 = new Label("Enter Trade License Number");

        Label lblResult = new Label("");

        Add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    String name = tfmemberName.getText().trim();
                    String balanceStr = tfaccountBalance.getText().trim();
                    String licenseStr = tflicense.getText().trim();

                    if (name.isEmpty() || balanceStr.isEmpty() || licenseStr.isEmpty()) {
                        lblResult.setText("Error: Please fill in all fields!");
                        return;
                    }

                    int balance = Integer.parseInt(balanceStr);
                    int license = Integer.parseInt(licenseStr);

                    Random rand = new Random();
                    String accountNumber = Integer.toString(rand.nextInt(10)) +
                            Integer.toString(rand.nextInt(10)) +
                            Integer.toString(rand.nextInt(10)) +
                            Integer.toString(rand.nextInt(10)) +
                            Integer.toString(rand.nextInt(10));

                    BufferedWriter writer = new BufferedWriter(new FileWriter(accountNumber + ".txt"));
                    String line = accountNumber + ":" + name + ":" + balance + ":" + license;
                    writer.write(line, 0, line.length());
                    writer.close();

                    lblResult.setText("Success! Account Created.\nAccount Number: " + accountNumber);

                    tfmemberName.clear();
                    tfaccountBalance.clear();
                    tflicense.clear();

                } catch (NumberFormatException e) {
                    lblResult.setText("Error: Please enter valid numbers for Balance and License!");
                } catch (IOException e) {
                    lblResult.setText("Error: Could not create account file!");
                    e.printStackTrace();
                } catch (Exception e) {
                    lblResult.setText("An unexpected error occurred!");
                    e.printStackTrace();
                }
            }
        });

        VBox vbox = new VBox(10);
        tfmemberName.setMaxWidth(180);
        tfaccountBalance.setMaxWidth(180);
        tflicense.setMaxWidth(180);

        vbox.getChildren().addAll(label1, tfmemberName, label2, tfaccountBalance, label3, tflicense, Add, lblResult);

        Scene SecondScene = new Scene(vbox, 500, 360);
        Stage newWindow = new Stage();
        newWindow.setTitle("Enter Current Account Data");
        newWindow.setScene(SecondScene);
        newWindow.setX(primaryStage.getX() + 350);
        newWindow.setY(primaryStage.getY() + 0);

        newWindow.show();
    }
}

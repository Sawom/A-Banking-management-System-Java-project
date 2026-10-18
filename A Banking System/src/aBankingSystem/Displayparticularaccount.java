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

public class Displayparticularaccount implements Serializable {
    public Displayparticularaccount() {
        Stage primaryStage = new Stage();
        TextField tfaccNum = new TextField();
        Button Add = new Button("Click Here");
        Label label1 = new Label("Enter Account Number:");

        Label lblAccNum = new Label("");
        Label lblName = new Label("");
        Label lblBalance = new Label("");
        Label lblLimit = new Label("");
        Label lblError = new Label("");

        Add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String accountNumber = tfaccNum.getText().trim();

                lblError.setText("");
                lblAccNum.setText("");
                lblName.setText("");
                lblBalance.setText("");
                lblLimit.setText("");

                if (accountNumber.isEmpty()) {
                    lblError.setText("Please enter an Account Number!");
                    return;
                }

                File file = new File(accountNumber + ".txt");
                if (!file.exists()) {
                    lblError.setText("Account file not found!");
                    return;
                }

                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line = br.readLine();
                    boolean found = false;

                    while (line != null) {
                        String[] arrOfStr = line.split(":", -1);
                        if (arrOfStr.length >= 4 && accountNumber.equals(arrOfStr[0])) {
                            lblAccNum.setText("Account Number: " + arrOfStr[0]);
                            lblName.setText("Name: " + arrOfStr[1]);
                            lblBalance.setText("Account Balance: " + arrOfStr[2]);
                            lblLimit.setText("Max Withdraw Limit: " + arrOfStr[3]);

                            found = true;
                            break;
                        }
                        line = br.readLine();
                    }

                    if (!found) {
                        lblError.setText("Account details not found in file!");
                    }

                } catch (Exception e) {
                    lblError.setText("Error reading account details!");
                    e.printStackTrace();
                }
            }
        });

        VBox vbox = new VBox(8);
        tfaccNum.setMaxWidth(180);

        vbox.getChildren().addAll(
                label1, tfaccNum, Add,
                lblError, lblAccNum, lblName, lblBalance, lblLimit
        );

        Scene SecondScene = new Scene(vbox, 500, 320);
        Stage newWindow = new Stage();
        newWindow.setTitle("Enter Particular Account Data");
        newWindow.setScene(SecondScene);
        newWindow.setX(primaryStage.getX() + 350);
        newWindow.setY(primaryStage.getY() + 0);

        newWindow.show();
    }
}

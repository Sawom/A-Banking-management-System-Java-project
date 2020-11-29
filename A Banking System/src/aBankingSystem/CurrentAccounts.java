package aBankingSystem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.Serializable;

public class CurrentAccounts implements Serializable  {
	 CurrentAccounts(){
        Stage primaryStage=new Stage();
        TextField tfmemberName = new TextField();
        TextField tfaccountBalance = new TextField();
        TextField tflicense = new TextField();
        TextField tfSal = new TextField();
        Button Add=new Button("Click Here");
        Label label1 = new Label("Enter Member Name");
        Label label2 = new Label("Enter Account Balance:");
        Label label3= new Label("Enter Trade License Number");
      
        Add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                
				Main.bc. SavingsAccount(tfmemberName.getText(),Integer.parseInt(tfaccountBalance.getText()),Integer.parseInt(tflicense.getText()) );
            }
        });

        VBox vbox = new VBox();
        tfmemberName.setMaxWidth(150);
        tfaccountBalance.setMaxWidth(150);
        tflicense.setMaxWidth(150);
       
        vbox.getChildren().addAll(label1,tfmemberName,label2,tfaccountBalance,label3,tflicense,Add);
        Scene SecondScene = new Scene(vbox, 500, 250);
        Stage newWindow = new Stage();
        newWindow.setTitle("Enter Currrent Account Data");
        newWindow.setScene(SecondScene);
        newWindow.setX(primaryStage.getX() + 350);
        newWindow.setY(primaryStage.getY() + 0);

        newWindow.show();
    }
}
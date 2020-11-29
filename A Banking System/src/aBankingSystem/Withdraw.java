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

public class Withdraw implements Serializable  {
	 Withdraw(){
        Stage primaryStage=new Stage();
        TextField tfaccNum = new TextField();
        TextField tfwithAmount= new TextField();
     
        Button Add=new Button("Click Here");
        Label label1 = new Label("Account Number:");
        Label label2 = new Label(" Account Balance:");
      
      
        Add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                
					Main.bc. withdraw (tfaccNum.getText(),Integer.parseInt(tfwithAmount.getText()) );
            }
        });

        VBox vbox = new VBox();
        tfaccNum.setMaxWidth(150);
        tfwithAmount.setMaxWidth(150);
      
        vbox.getChildren().addAll(label1,tfaccNum,label2,tfwithAmount,Add);
        Scene SecondScene = new Scene(vbox, 500, 250);
        Stage newWindow = new Stage();
        newWindow.setTitle("Enter Withdraw Account Data");
        newWindow.setScene(SecondScene);
        newWindow.setX(primaryStage.getX() + 350);
        newWindow.setY(primaryStage.getY() + 0);
        newWindow.show();
    }
}
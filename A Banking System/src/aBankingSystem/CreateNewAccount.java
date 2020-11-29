package aBankingSystem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.Serializable;

public class CreateNewAccount implements Serializable {
	CreateNewAccount(){
        Stage primaryStage = new Stage();
        VBox vbox = new VBox();
        TextField tfMemberName = new TextField();
        TextField tfAccountBalance = new TextField();
        TextField tfMaxwithLimit = new TextField();
      
        Button SavingsAccount= new Button("SavingsAccount");
        Button CurrentAccount= new Button("CurrentAccount");

        SavingsAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override

                public void handle(ActionEvent actionEvent) {
          
            	new SavingAccount ();
            	
                }
        });
        CurrentAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new CurrentAccounts();
            }
        });
      
        SavingsAccount.setMaxSize(160,160);
        CurrentAccount.setMaxSize(160,160);
      
        vbox.setPadding(new Insets(40, 0, 0, 130));
        vbox.getChildren().addAll(SavingsAccount,CurrentAccount);
        Scene secondScene = new Scene(vbox, 500, 250);
        Stage newWindow = new Stage();
        newWindow.setTitle("Choice your option");
        newWindow.setScene(secondScene);
        newWindow.setX(primaryStage.getX() + 350);
        newWindow.setY(primaryStage.getY() + 0);

        newWindow.show();
    }
}

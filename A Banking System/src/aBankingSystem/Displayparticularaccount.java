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
import java.io.*;

public class Displayparticularaccount implements Serializable  {
	Displayparticularaccount(){
        Stage primaryStage=new Stage();
        TextField tfaccNum = new TextField();
        Button Add=new Button("Click Here");
        Label label1 = new Label(" Enter Account Number:");
        Add.setOnAction(new EventHandler<ActionEvent>() {
             @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    String accountNumber = tfaccNum.getText();
                    BufferedReader br = new BufferedReader(new FileReader(accountNumber+".txt")); 
                    String line = br.readLine();
                    while(line != null){
                        String[] arrOfStr = line.split(":", -1); 
                        if(accountNumber.equals(arrOfStr[0])){
                            System.out.println("account number:"+arrOfStr[0]);
                            System.out.println("name:"+arrOfStr[1]);
                            System.out.println("amount:"+arrOfStr[2]);
                            System.out.println("maximum withdraw limit:"+arrOfStr[3]);
                        }
                        line = br.readLine();
                    }
                    br.close();
                }catch(Exception e){
                	System.out.println("Error!Please Enter correct order");
                }
            }
        });

        VBox vbox = new VBox();
        tfaccNum.setMaxWidth(150);
        vbox.getChildren().addAll(label1,tfaccNum,Add);
        Scene SecondScene = new Scene(vbox, 500, 250);
        Stage newWindow = new Stage();
        newWindow.setTitle("Enter Particular Account Data");
        newWindow.setScene(SecondScene);
        newWindow.setX(primaryStage.getX() + 350);
        newWindow.setY(primaryStage.getY() + 0);

        newWindow.show();
    }
}

package aBankingSystem;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {
    static String fileName="BankData.txt";

    public static void main(String[] args) {
       Bank bank=readData();
       Bank b=saveData(bank);
       launch(args);
    }
        Button CreateNewAccount;
        Button Deposit;
        Button Withdraw;
        Button Displayparticularaccount;
        Button Checkbalance;
        Button Exit;
        static Bank bc= new Bank();

        @Override
        public void start(Stage primaryStage) {
        	CreateNewAccount= new Button("Create New Account");
        	Deposit = new Button("Deposit");
        	Withdraw = new Button("Withdraw");
        	Displayparticularaccount = new Button ("Display Particular Account Info");
        	Checkbalance = new Button("Check balance");
            Exit = new Button("Exit");
            
            Bank bc=new Bank();
            CreateNewAccount.setOnAction(new EventHandler<ActionEvent>() {
				@Override
                public void handle(ActionEvent event) {
                   new CreateNewAccount();
                }
            });
             Deposit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
               public void handle(ActionEvent actionEvent) {
               new Deposit();
                }
            });
             
             Withdraw.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                   new Withdraw();
                }
            });
             Displayparticularaccount.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent actionEvent) {
                    new Displayparticularaccount();
                 }
             });
           
             Checkbalance.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent actionEvent) {
                   new Checkbalance();
                }
           });
            Exit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    saveData(bank);
                    System.out.println("Exit.Thank you.....");
                    System.exit(0);
                }
            });

            VBox vbox = new VBox();
            CreateNewAccount.setMaxSize(250,250);
            Deposit.setMaxSize(250,250);
            Withdraw.setMaxSize(250,250);
            Displayparticularaccount.setMaxSize(250,250);
          
            Checkbalance.setMaxSize(250,250);
            Exit.setMaxSize(250,250);
            vbox.setPadding(new Insets(40, 0, 0, 130));
            vbox.getChildren().addAll(CreateNewAccount,Deposit,Withdraw,Displayparticularaccount, Checkbalance,Exit);

            Scene scene = new Scene(vbox, 500, 250);

            primaryStage.setTitle("A Banking  System");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
	 Bank bank=new Bank();
    private static Bank readData() {
        Bank bank=new Bank();
        try{
            FileInputStream fis=new FileInputStream(fileName);
            ObjectInputStream ois=new ObjectInputStream(fis);
            bank=(Bank) ois.readObject();
           
        }catch (IOException | ClassNotFoundException e){
            System.out.println("No Data Available");
        }
        return bank;
    }
    public static Bank saveData(Bank b) {
        try {
            ObjectOutputStream p = new ObjectOutputStream(new FileOutputStream(fileName));
            p.writeObject(b);
            p.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}

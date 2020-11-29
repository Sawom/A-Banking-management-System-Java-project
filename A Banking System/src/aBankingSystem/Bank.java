package aBankingSystem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable {
	String bankName;
	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

	public Bank() {
		super();
		this.bankName = bankName;
	}

	private void addAccount(BankAccount acc) {
		accounts.add(acc);
	}

	void SavingsAccount(String Membername, double Accountbalance, double maxWithimit) {
		SavingsAccount b1 = new SavingsAccount(Membername, maxWithimit, maxWithimit);
		addAccount(b1);
		System.out.println("Success");
	}

	public void addAccount(String name, double balance, String tradeLicense) {
		CurrentAccount b1 = new CurrentAccount(name, balance, tradeLicense);
		addAccount(b1);
		System.out.println("Success");
	}

	private BankAccount findAccount(String accNum) {
		for (int i = 0; i < accounts.size(); i++) {
			BankAccount b = accounts.get(i);
			if (b.getAccNum().equals(accNum))
				return b;
		}
		return null;
	}

	public void deposit(String accNum, double depAmount) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(accNum + ".txt"));
			String line = br.readLine();
			String[] arrOfStr = line.split(":", -1);
			double currentAmount = Double.parseDouble(arrOfStr[2]);
			br.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(accNum + ".txt"));
			line = accNum + ":" + arrOfStr[1] + ":" + Double.toString(currentAmount+depAmount) 
				+ ":" + arrOfStr[3];
			writer.write(line, 0, line.length());
			writer.close();
		} catch (Exception e) {
			System.out.println("Error!!");
		}
	}

	public void withdraw(String accNum, double withAmount) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(accNum + ".txt"));
			String line = br.readLine();
			String[] arrOfStr = line.split(":", -1);
			double currentAmount = Double.parseDouble(arrOfStr[2]);
			br.close();
			if(withAmount>currentAmount){
				System.out.println("not enough money...");
				return;
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(accNum + ".txt"));
			line = accNum + ":" + arrOfStr[1] + ":" + Double.toString(currentAmount-withAmount) 
				+ ":" + arrOfStr[3];
			writer.write(line, 0, line.length());
			writer.close();
		} catch (Exception e) {
			System.out.println("Error!Please Enter correct order");
		}
	}

	public void display(String accNum) {
		getBalance(accNum );
	}

	public double getBalance(String accNum) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(accNum + ".txt"));
			String line = br.readLine();
			String[] arrOfStr = line.split(":", -1);
			double currentAmount = Double.parseDouble(arrOfStr[2]);
			System.out.println("current balance : "+currentAmount);
			return currentAmount;
		}catch(Exception e) {
			System.out.println("Account not found");
		}
		return -1;
	}

	public void display() {
		System.out.println(bankName);
		for (int i = 0; i < accounts.size(); i++) {
			BankAccount b = accounts.get(i);
			b.display();
		}
	}
}

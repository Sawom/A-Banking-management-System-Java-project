package aBankingSystem;
public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message);
	}
	
	public InsufficientBalanceException(double amt) {
		super("Can't withdraw more than " + amt + " taka.");
	}

}
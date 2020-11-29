package aBankingSystem;
class CurrentAccount extends BankAccount{
	private String tradeLicenseNumber;
	public CurrentAccount(String memberName, double accountBalance, String license) {
		super(memberName, accountBalance, 2000);
		tradeLicenseNumber = license;
	}
	
	public String getTradeLicense(){
		return tradeLicenseNumber;
	}
	
	public void setTradeLicense(String license){
		tradeLicenseNumber=license;
	}
	
	public void display() {
		super.display();
		System.out.println("; Trade License:" + tradeLicenseNumber);
	}
}
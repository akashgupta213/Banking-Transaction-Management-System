package model;

public class Account {
	private String accNumber;
	private String custName;
	private double balance;
	
	
	public Account(String accNumber, String custName, double balance) {
		super();
		this.accNumber = accNumber;
		this.custName = custName;
		this.balance = balance;
	}
	
	
	public Account() {
		super();
	}


	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	

}

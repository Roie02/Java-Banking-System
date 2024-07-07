public class Savings extends Account {
	
	private double interestRate;
	
	public Savings(Currency initial, double rate) {
		super(initial);
		interestRate = rate;
	}

	public void deposit(Currency amount) {
		System.out.print(initAmount.add(amount));
	}
	
	public void withdraw(Currency amount) {
		System.out.print(initAmount.subtract(amount));
	}

	public Currency getBalance() {
		return initAmount;
	}
	
	public double getRate() {
		return interestRate;
	}
	
	public String toString() {
		return "New Balance: $" + initAmount;
	}


}

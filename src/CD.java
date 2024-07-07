public class CD extends Account{

	private double interestRate;

	public CD(Currency initialAmount, double rate) {
		super(initialAmount);
		interestRate = rate;
	}
	public void deposit(Currency amount) {
		try {
			initAmount.add(amount);
		}catch(Exception e) {
			new Exception("Error: Can't deposit from a CD Account");
		}
	}
	public void withdraw(Currency amount) {
		try {
			initAmount.subtract(amount);
		}catch(Exception e) {
			new Exception("Error: Cant withdraw from a CD Account");
		}
	}

	public Currency getBalance() {
		return initAmount;
	}

	public String toString() {
		return "New Balance: $" + initAmount;

	}
}

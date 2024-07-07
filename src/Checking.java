public class Checking extends Account {
	
	public Checking(Currency initialAmount) {
		super(initialAmount);
	}
	public void deposit(Currency amount) {
		System.out.print(initAmount.add(amount));

	}
	public void withdraw(Currency amount) {
		System.out.print(initAmount.subtract(amount));
	}
	
	public Currency getBalance(){
		return initAmount;
	}

	public String toString() {
		return "New Balance: $" + initAmount;
	}

}

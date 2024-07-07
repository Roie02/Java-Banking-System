public abstract class  Account {

	protected Currency initAmount;
	
	public Account(Currency initialDeposit) {
		initAmount = initialDeposit;
	}

	public abstract void withdraw(Currency amount);

	public abstract void deposit(Currency amount);

	abstract Currency getBalance();

}

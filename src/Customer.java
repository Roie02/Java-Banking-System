import java.util.*;

public class Customer {
	//declaring instance variables
	private String firstName;
	private String lastName;
	private int numAccounts;
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public Customer(String first, String last) {
		//instantiating instance variables
		firstName = first;
		lastName = last;
	}

	public void addAccount(Account account) {
		accounts.add(account); //add an account to ArrayList accounts
		numAccounts++;

	}
	public String getFirstName() {
		return firstName; 
	}

	public String getLastName() {
		return lastName;
	}

	public int getBalance(String type) {
		for (Account account : accounts) {
			if (type.equalsIgnoreCase("Savings")) {
				if (account instanceof Savings) {
					return account.getBalance().getValue();
				}
			}else if(type.equalsIgnoreCase("Checking")) {
				if (account instanceof Checking) {
					return account.getBalance().getValue();
				}
			}else if(type.equalsIgnoreCase("CD")) {
				if (account instanceof CD) {
					return account.getBalance().getValue();
				}
			}
		}
		return 0;
	}

	public void deposit(Currency money, String type) throws Exception {
		for (Account account : accounts) {
			if (type.equalsIgnoreCase("Savings")) {
				if (account instanceof Savings) {
					account.deposit(money);
				}
			}else if(type.equalsIgnoreCase("Checking")) {
				if (account instanceof Checking) {
					account.deposit(money);
				}
			}else if(type.equalsIgnoreCase("CD")) {
				if (account instanceof CD) {
					System.out.println("Can't Deposit to a CD account");
				}
			}else {
				throw new AccountDoesNotExistException("Error: No Such Account Type");
			}
		}
	}

	public void withdraw(Currency money, String type) throws Exception{
        for (Account account : accounts) {
            if (type.equalsIgnoreCase("Savings")) {
                if (account instanceof Savings) {
                    if(money.getValue()<account.getBalance().getValue())
                    account.withdraw(money);
                    else {
                    	throw new Exception("Insufficent Funds");
                    }
                }
            }else if(type.equalsIgnoreCase("Checking")) {
                if (account instanceof Checking) {
                    if(money.getValue()<account.getBalance().getValue())
                    account.withdraw(money);
                    else {
                    	throw new Exception("Insufficent Funds");
                    }
                }
            }else if(type.equalsIgnoreCase("CD")) {
                if (account instanceof CD) {
                    System.out.println("Can't Withdraw from a CD account");
                }
            }
        }

    }

	public void balance(String type) throws Exception {
		for (Account account : accounts) {
			if (type.equalsIgnoreCase("Savings")) {
				if (account instanceof Savings) {
					account.getBalance();
				}
			}else if(type.equalsIgnoreCase("Checking")) {
				if (account instanceof Checking) {
					account.getBalance();
				}
			}else if(type.equalsIgnoreCase("CD")) {
				if (account instanceof CD) {
					account.getBalance();
				}
			}else {
				throw new AccountDoesNotExistException("Error: No Such Account Type");
			}
		}
	}

}

import java.util.*; //import java util package
import java.io.*; //import java io package
public class Main {

	public static void main(String[] args) throws Exception {

		ArrayList<Customer> bank = new ArrayList<Customer>(); //ArrayList bank
		PrintWriter outputFile = new PrintWriter("myoutput.txt"); //Creating outputFile
		Scanner sc = new Scanner(System.in); //Create Scanner
		
		while(true) {
			menu();
			String choice = sc.next();
			outputFile.println(choice);
			//switch statement
			switch (choice.toUpperCase()) {
			
			//switch case W (Withdraw)
			case "W":
				System.out.print("Enter your first name: ");
				String first = sc.next();
				outputFile.println(first);
				System.out.print("Enter your last name: ");
				String last = sc.next();
				outputFile.println(last);
				System.out.print("Enter an Account type: ");
				String account = sc.next();
				outputFile.println(account);
				System.out.print("Enter an amount to withdraw: ");
				int Amount = sc.nextInt();
				outputFile.println(Amount);
				Currency amount = new Currency(Amount);

				for (int i = 0; i < bank.size(); i++) {
					if (bank.get(i).getFirstName().equalsIgnoreCase(first) && bank.get(i).getLastName().equalsIgnoreCase(last)) {
						try {
							bank.get(i).withdraw(amount, account);
							outputFile.println("Withdraw Complete. Withdraw Amount: $" + Amount/100 + " New Balance: $" + bank.get(i).getBalance(account)/100);
						} catch (Exception e) {
							outputFile.println("Error: " + e.getMessage());
						}
					}
				}

				break;
				//switch case D (Deposit)
			case "D":
				System.out.print("Enter your first name: ");
				first = sc.next();
				outputFile.println(first);
				System.out.print("Enter your last name: ");
				last = sc.next();
				outputFile.println(last);
				System.out.print("Enter an Account type: ");
				account = sc.next();
				outputFile.println(account);
				System.out.print("Enter an amount to deposit: ");
				Amount = sc.nextInt();
				outputFile.println(Amount);
				amount = new Currency(Amount);

				for (int i = 0; i < bank.size(); i++) {
					if (bank.get(i).getFirstName().equalsIgnoreCase(first) && bank.get(i).getLastName().equalsIgnoreCase(last)) {
						try {
							bank.get(i).deposit(amount, account);
							outputFile.println("Deposit Complete. Deposit Amount: $" + Amount/100 + " New Balance: $" + bank.get(i).getBalance(account)/100);
						} catch (Exception e) {
							System.out.println("Error: " + e.getMessage());
						}

					}
				}
				break;
				//switch case B (Balance)
			case "B":
				System.out.print("Enter your first name: ");
				first = sc.next();
				outputFile.println(first);
				System.out.print("Enter your last name: ");
				last = sc.next();
				outputFile.println(last);
				System.out.print("Enter an Account type: ");
				account = sc.next();
				outputFile.println(account);

				for (int i = 0; i < bank.size(); i++) {
					if (bank.get(i).getFirstName().equalsIgnoreCase(first) && bank.get(i).getLastName().equalsIgnoreCase(last)) {
						try {
							System.out.println(bank.get(i).getBalance(account));
							outputFile.println("Current Balance in your " + account + " is: $" + bank.get(i).getBalance(account)/100);
						} catch (Exception e) {
							System.out.println("Error: " + e.getMessage());
						}

					}
				}
				break;
				//switch case C (New Account)
			case "C":
				System.out.print("Enter your first name: ");
				first = sc.next();
				outputFile.println(first);
				System.out.print("Enter your last name: ");
				last = sc.next();
				outputFile.println(last);
				System.out.print("Enter an Account type: ");
				account = sc.next();
				System.out.print("Enter an initial amount: ");
				Amount = sc.nextInt();
				outputFile.println(Amount);
				amount = new Currency(Amount);

				if (account.equalsIgnoreCase("Checking")) {
					for (int i = 0; i < bank.size(); i++) {
						if (bank.get(i).getFirstName().equalsIgnoreCase(first) && bank.get(i).getLastName().equalsIgnoreCase(last)) {
							try {
								bank.get(i).addAccount(new Checking(amount));
								outputFile.println("Congratulations: You Opened A Checking Account With $" + Amount/100);
							} catch (Exception e) {
								throw new Exception("You don't have an account at this bank");

							}
						}
					}
				}
				if (account.equalsIgnoreCase("Savings")) {
					for (int i = 0; i < bank.size(); i++) {
						if (bank.get(i).getFirstName().equalsIgnoreCase(first) && bank.get(i).getLastName().equalsIgnoreCase(last)) {
							try {
								bank.get(i).addAccount(new Savings(amount, Amount));
								outputFile.println("Congratulations: You Opened A Savings Account With $" + Amount/100);
							} catch (Exception e) {
								throw new Exception("You don't have an account at this bank");
							}
						}
					}
				}

				if (account.equalsIgnoreCase("CD")) {
					for (int i = 0; i < bank.size(); i++) {
						if (bank.get(i).getFirstName().equalsIgnoreCase(first) && bank.get(i).getLastName().equalsIgnoreCase(last)) {
							try {
								bank.get(i).addAccount(new CD(amount, Amount)); }
							catch (Exception e) {
								throw new Exception("You don't have an account at this bank"); }
						}
					}
				}
				break;
				//switch case O (Open account)
			case "O":
				System.out.print("Enter your first name: ");
				first = sc.next();
				outputFile.println(first);
				System.out.print("Enter your last name: ");
				last = sc.next();
				outputFile.println(last);
				if(bank.isEmpty())
				{
					bank.add(new Customer(first, last));
					outputFile.println("Welcome: You have made a new account with this bank");
					break;
				}
				for (Customer customer : bank) {
					if (customer.getFirstName().equalsIgnoreCase(first) && customer.getLastName().equalsIgnoreCase(last)) {
						outputFile.println("You are already registered.");
						break;
					}

				}
				bank.add(new Customer(first, last));
				break;
				//switch case Q (Quit)
			case "Q":
				outputFile.println("--Program Ended--");
				outputFile.close(); //close outputFile
				System.exit(1);
				break;
				//default case 
			default:
				outputFile.println("Error: Transaction Type Invalid: " + choice);				
				break;
			}
		}
		
	
		
	}
	
	/* method menu()
	 *  Input:
	 *  	No Input
	 *  Process:
	 *  	Displays a menu of all the operations the user can choose from
	 *  Output:
	 *  	Prints the menu in the console
	 */

	public static void menu() {
		System.out.println(
				"W - Withdrawal\n" +
						"D - Deposit\n" +
						"C - New account\n" +
						"B - Balance\n" +
						"O - Open Account\n" +
				"Q – Quit");
		System.out.print("Select one of the following transactions: ");
	}

}
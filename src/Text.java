
public class Text {

	public static void mainMenu() {
		System.out.print("---MAIN MENU---\n\n"
				+ "1) Create New Account\n"
				+ "2) Add New Book To Library\n"
				+ "3) Loan Book\n"
				+ "4) Accounts Details\n\n"
				+ "0) Exit\n\n"
				+ "Your Choice: ");
	}
	
	public static void createAccount() {
		System.out.println("--CREATE ACCOUNT--\n");
	}
	
	public static void nameInput() {
		System.out.print("Enter Your Name: ");
	}
	
	public static void surnameInput() {
		System.out.print("Enter Your Surname: ");
	}
	
	public static void successfullyCreatedAcc() {
		System.out.println("*Your Have Created Account In Our Library.\n");
	}
	
	public static void accountInfo(Account account) {
		System.out.println("--ACCOUNT INFO--\n\n"
				+ " -Name: " + account.getName() + "\n"
				+ " -Surname: " + account.getSurname() + "\n"
				+ " -Account Number: " + account.getNumber() + "\n"
				+ " -Number Of Loan Books: " + account.getBookLoanNumber());
	}
	
}

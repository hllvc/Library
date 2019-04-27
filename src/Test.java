import java.util.Scanner;

public class Test {

	private static Account account;
	private static Book book;
	private static Scanner input = new Scanner(System.in);
	
	private static void createAccount() {
		Text.createAccount();
		Text.nameInput();
		String name = input.nextLine();
		Text.surnameInput();
		String surname = input.nextLine();
		account = new Account(name, surname);
		Text.accountInfo(account);
	}
	
	private static void addNewBook() {
		
	}
	
	private static void mainMenu() {
		byte choice;
		do {
			Text.mainMenu();
			choice = input.nextByte();
			switch (choice) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			default:
			}
		} while (choice != 0);
	}
	
	public static void main(String[] args) {
		
		
		
	}
	
}

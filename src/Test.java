import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	private static Account account;
	private static Book book;
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Account> allAccounts = new ArrayList<>();
	private static ArrayList<Book> allBooks = new ArrayList<>();
	
	private static void createAccount() {
		Text.createAccount();
		Text.nameInput();
		String name = input.nextLine();
		Text.surnameInput();
		String surname = input.nextLine();
		account = new Account(name, surname);
		allAccounts.add(account);
		Text.accountInfo(account);
	}
	
	private static void addNewBook() {
		Text.addBook();
		Text.bookNameInput();
		String name = input.nextLine();
		book = new Book(name);
		allBooks.add(book);
		Text.bookInfo(book);
	}
	
	private static void loanBook() {
		Text.loanBook();
		Text.accNumberInput();
		int accNumber = input.nextInt();
		for (Account x: allAccounts)
			if (x.getNumber() == accNumber)
				account = x;
		Text.bookNumberInput();
		int bookNumber = input.nextInt();
		for (Book x: allBooks)
			if (x.getNumber() == bookNumber)
				book = x;
		account.addBook(book);
	}
	
	private static void mainMenu() {
		byte choice;
		do {
			Text.mainMenu();
			choice = input.nextByte();
			switch (choice) {
			case 1:
				createAccount();
				break;
			case 2:
				addNewBook();
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

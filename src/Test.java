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
		int accNumber;
		do {
			Text.accNumberInput();
			accNumber = input.nextInt();
			if (Checker.checkNumberLenght(accNumber))
				Text.numberLenght();
		} while (Checker.checkNumberLenght(accNumber));
		do {
			account = null;
			for (Account x: allAccounts)
				if (x.getNumber() == accNumber) {
					account = x;
					break;
				}
			if (account == null)
				Text.noAccount();
		} while (account == null);
		Text.bookNumberInput();
		int bookNumber;
		do {
			bookNumber = input.nextInt();
			if (Checker.checkNumberLenght(bookNumber))
				Text.numberLenght();
		} while (Checker.checkNumberLenght(bookNumber));
		do {
			book = null;
			for (Book x: allBooks)
				if (x.getNumber() == bookNumber)
					book = x;
			if (book == null)
				Text.noBook();
		} while ( book == null);
		account.addBook(book);
	}
	
	private static void allAccInfo() {
		Text.allAccounts();
		for (Account x: allAccounts) {
			Text.accountInfo(x);
			x.getLoanedBooks();
		}
	}
	
	private static void mainMenu() {
		byte choice;
		do {
			Text.mainMenu();
			choice = input.nextByte();
			input.nextLine();
			switch (choice) {
			case 1:
				createAccount();
				break;
			case 2:
				addNewBook();
				break;
			case 3:
				loanBook();
				break;
			case 4:
				allAccInfo();
				break;
			default:
				if (choice != 0)
					Text.noOptions();
			}
		} while (choice != 0);
	}
	
	public static void main(String[] args) {
		
		mainMenu();
		input.close();
		Text.exit();
		
	}
	
}

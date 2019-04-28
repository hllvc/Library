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
	
	public static boolean checkNumberLenght(int number) {
		if (Integer.toString(number).length() != 4)
			return true;
		return false;
	}
	
	public static boolean checkForBooks() {
		if (allBooks.isEmpty())
			return true;
		return false;
	}
	
	public static boolean checkForAccounts() {
		if (allAccounts.isEmpty())
			return true;
		return false;
	}
	
	public static boolean checkForLoaned() {
		boolean loaned = true;
		for (Book x: allBooks)
			if (!x.isStatus())
				loaned = false;
		return loaned;
	}
	
	public static boolean checkBookStatus(Book book) {
		if (book.isStatus())
			return true;
		return false;
	}
	
	public static boolean checkLoanedNumber(Account x) {
		if (x.getBookLoanNumber() < 3)
			return false;
		return true;
	}
	
	private static void loanBook() {
		if (checkForBooks() || checkForAccounts() || checkForLoaned()) {
			if (checkForAccounts())
				Text.noAccounts();
			else if (checkForBooks())
				Text.noBooks();
			else if (checkForLoaned())
				Text.allLoaned();
			return;
		}
		
		Text.loanBook();
		int accNumber;
		do {
			Text.accNumberInput();
			accNumber = input.nextInt();
			if (checkNumberLenght(accNumber)) {
				Text.numberLenght();
				continue;
			}
			account = null;
			for (Account x: allAccounts)
				if (x.getNumber() == accNumber) {
					account = x;
					break;
				}
			if (account == null)
				Text.noAccount();
			else if (checkLoanedNumber(account)) {
				Text.limit();
				return;
			}
		} while (checkNumberLenght(accNumber) || account == null || checkLoanedNumber(account));
		int bookNumber;
		do {
			Text.bookNumberInput();
			bookNumber = input.nextInt();
			if (checkNumberLenght(bookNumber)) {
				Text.numberLenght();
				continue;
			}
			book = null;
			for (Book x: allBooks)
				if (x.getNumber() == bookNumber)
					book = x;
			if (book == null)
				Text.noBook();
			else if (book.isStatus())
				Text.taken();
		} while (checkNumberLenght(bookNumber) || book == null || book.isStatus());
		account.addBook(book);
	}
	
	private static void allAccInfo() {
		if (checkForAccounts()) {
			Text.noAccounts();
			return;
		}
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
